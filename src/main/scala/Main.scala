/**
* Main.scala - Principal class, options parsing
* @author Lanvin Victor Thiré François
* Copyright (c) 2014 GPLv3. See LICENCE file
*/

import java.io.File



object StandardMain {
  def main(args: Array[String]) {
  	val str = "j'adore ecouter la radio toute la journee";
  	val group = new Zadd(BigInt("531872289054204184185084734375133399408303613982130856645299464930952178606045848877129147820387996428175564228204785846141207532462936339834139412401975338705794646595487324365194792822189473092273993580587964571659678084484152603881094176995594813302284232006001752128168901293560051833646881436219"));
  	val crypter = new CryptoElGamal(group);
  	val (pk,sk) = crypter.generateKeys;
  	println (str);
  	val cryptstr = crypter.encrypt(str, pk, 10);
  	println (cryptstr);
  	println (crypter.decrypt(cryptstr, sk));
  }
}
