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
    val keys=rsa.generateKeys;
    val text="Bonjour je m'emmerde à mourrir sur la plage à abandonner coquillages et crustacées. Et ma chaîne est super long pour que ça plante !Bonjour je m'emmerde à mourrir sur la plage à abandonner coquillages et crustacées. Bonjour je m'emmerde à mourrir "
    val cipher=rsa.encrypt(text, keys._1,10);
    //println(cipher)
    /*
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
    println()*/
    println(rsa.decrypt(cipher,keys._2))
  }
}
