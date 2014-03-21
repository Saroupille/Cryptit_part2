/**
* Main.scala - Principal class, options parsing
* @author Lanvin Victor Thiré François
* Copyright (c) 2014 GPLv3. See LICENCE file
*/

import java.io.File



object StandardMain {
  def main(args: Array[String]) {
  	val str = "j'adore ecouter la radio toute la journee";
  	val crypter = new CryptoCesar();
  	val (pk,sk) = crypter.generateKeys;
  	println (str);
  	val cryptstr = crypter.encrypt(str, pk, 10);
  	println (cryptstr);
  	println (crypter.decrypt(cryptstr, sk));
    val rsa = new RSA();
    val keys=rsa.generateKeys
    println(rsa.decrypt(rsa.encrypt("coucou", keys._1,10),keys._2));
  }
}
