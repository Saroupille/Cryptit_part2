class CryptoElGamal[E] (group : Group[E]) extends CryptoSystem {
	class ElGamalPublicKey (init : E) extends PublicKey {
		type T = E
		val key = init
		def getKey : T = key
	}

	class ElGamalPrivateKey (init : BigInt) extends PrivateKey {
		type T = BigInt
		val key = init
		def getKey : T = key 
	}

	type PK = ElGamalPublicKey
	type SK = ElGamalPrivateKey

	def generateKeys : (ElGamalPublicKey, ElGamalPrivateKey) = {
		val randomInt = BigInt(1000, generator)%(group.order-1) + 1;
		val expoElt = group.exp(group.generator, randomInt);
		(new ElGamalPublicKey(expoElt), new ElGamalPrivateKey(randomInt));
	}

	def encrypt(msg:String, pub:PK, rdm:Int): String = {
		val randomInt = BigInt(1000, generator)%(group.order-1) + 1;
		val expoElt = group.exp(group.generator, randomInt);
		val sharedSecret = group.exp(pub.getKey, randomInt);
		def injectString : E = {
			var stringCode : BigInt = 0;
			for (i <- 0 to msg.length - 1) {
				stringCode = stringCode * 256 + msg(i).toInt
			}
			return group.fromBigInt(stringCode)
		}
		val cryptedMsg = group.combines(injectString, sharedSecret);

		return (group.toString(expoElt) + "#" + group.toString(cryptedMsg))
	}

 	def decrypt(msg:String, priv:SK): String = {
 		def cutString : (E,E) = {
 			var i = 0;
 			while (msg(i) != '#') {
 				i = i+1;
 			}
 			(group.fromString (msg.substring(0, i)), group.fromString (msg.substring(i+1)))
 		}
 		val (e1, e2) = cutString;
 		val sharedSecret = group.exp(e1, group.order - priv.getKey);
 		val cryptedMsg = group.toBigInt (group.combines(e2, sharedSecret));
 		def decryptString : String = {
 			val length = cryptedMsg.bitLength / 8 + 1;
 			var actualMsg : BigInt = cryptedMsg;
 			var chars : Array[Char] = new Array[Char](length);
 			for (i <- 1 to length) {
 				chars(length-i) = (actualMsg % 256).toChar;
 				actualMsg = actualMsg / 256;
 			}
 			return chars.mkString
 		}
 		return decryptString	
	}
}
