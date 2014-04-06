/**
* Main.scala - Principal class, options parsing
* @author Lanvin Victor Thiré François
* Copyright (c) 2014 GPLv3. See LICENCE file
*/

import java.io.File



object StandardMain {
  def main(args: Array[String]) {
  	val str = "Coucou, c'est moi. Je suis Skynet.";
  	/* Oui, ceci est nombre premier à 300 chiffres */
  	val magicprime = BigInt("531872289054204184185084734375133399408303613982130856645299464930952178606045848877129147820387996428175564228204785846141207532462936339834139412401975338705794646595487324365194792822189473092273993580587964571659678084484152603881094176995594813302284232006001752128168901293560051833646881436219");
  	val group = new Zmult(magicprime);
  	val crypter = new CryptoElGamal(group);
  	val (pk,sk) = crypter.generateKeys;
  	println (str);
  	val cryptstr = crypter.encrypt(str, pk, 10);
  	println (cryptstr);
  	println (crypter.decrypt(cryptstr, sk));

    /*val rsa = new RSA();
    val keys=rsa.generateKeys;
    val text="aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"

    val cipher=rsa.encrypt(text, keys._1,10);
    //println(cipher)
    val bytes=BigInt(cipher).toByteArray
    println(bytes.length)
    //println(bytes)
    for(a <-0 to bytes.length-1)
      print(bytes(a))
    println()
    val string=new String(bytes)
    println(string)
    val bytes2 =string.getBytes
    for(a <-0 to bytes.length-1)
      print(bytes2(a))
    println()
    //STRANGE : bytes!= bytes2 but string=string2
    val string2=new String(bytes2)
    println(new String(bytes2))
    val bytes3= string2.getBytes
    for(a <-0 to bytes.length-1)
      print(bytes2(a))
    println()
    println(rsa.decrypt(cipher,keys._2))

    println(rsa.decrypt(cipher,keys._2))*/
  }
}
