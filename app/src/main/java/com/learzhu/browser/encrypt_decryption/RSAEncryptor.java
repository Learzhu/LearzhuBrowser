package com.learzhu.browser.encrypt_decryption;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
//import sun.misc.BASE64Decoder;
//import sun.misc.BASE64Encoder;

/**
 * RSA 加密类
 */
public class RSAEncryptor {

    /*支付密钥*/
    public interface PAY_SECRET_KEY {
        String PUBLIC_KEY = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCvLT1mAuHoT8cUYvf1T6J4U0mXJYDsYrA+vtFqNmWujdnSo922M4Bst7qXHRSIcEoD4bFRbykYch/XXcs0W/rMkwN747aARLtLClAauezKfi2bvY82oh9rbow9CPnfwGxvGwTCq5o94YR7QTAqJB64rNBUdRXQkap5Y/IQfdG0EQIDAQAB";
        String PRIVATE_KEY = "MIICdgIBADANBgkqhkiG9w0BAQEFAASCAmAwggJcAgEAAoGBAK8tPWYC4ehPxxRi9/VPonhTSZclgOxisD6+0Wo2Za6N2dKj3bYzgGy3upcdFIhwSgPhsVFvKRhyH9ddyzRb+syTA3vjtoBEu0sKUBq57Mp+LZu9jzaiH2tujD0I+d/AbG8bBMKrmj3hhHtBMCokHris0FR1FdCRqnlj8hB90bQRAgMBAAECgYA4vnHOEo70/qqhKvHhL7uUOH51DHv3lnw6xvr06cwEQATYG6ac94/ZJ6a0foIBNEZ1fW0/0L9CIO25iLNjMYxKoOvvrpc5k9bvv+QgPAyaa+AN43C99F9zASMbPOOhfjim5oi9Rn3gKO+WjnCL9BWePxND9JYNgy0wodKF08tasQJBANrOJRffwi/FPFeIJvhA3w4DNcnTaaJiMqR1RKcLk8/Ez0X5fgaT59OeV1Sz/5pIsb48P0FTO4g+3J0B5QekqWUCQQDM9H2blHbfcwR5dEX/I1uwe4KAdElKGhuKETnEMGAOY/XACqfKbgwr1RhVssbKgF5BM0wPbSGOqeAN0acZNgs9AkBwuDY/wFQni/J0HX4F8lV2wIybNsB6mSABvS/q5nn1VSx6nfcgqF2LlUzkI/6PmteGaz8jBh/rJoc8k1dLwrZJAkBkMWluMyfhmHKphSPq1DgwkFB9x1tEtHqeBkm9FQEAR/GNTig0l5Ovod7hliIEQLjTGual6+2ptnXni4QqmPbpAkEAzPyfGh+kOKng3akSJA8k5Z32oY7HBUikocbYSLfCvkRiWZcZRQuXUaBAel1HURNoZDXTQ+5wRPA7I0Ky1DR45w==";
    }

    public static String private_key = PAY_SECRET_KEY.PRIVATE_KEY;
    public static String public_key = PAY_SECRET_KEY.PUBLIC_KEY;
//	public static String  private_key = ResourceBundle.getBundle("config/rsa").getString("rsa.privateKey");
//	public static String  public_key = ResourceBundle.getBundle("config/rsa").getString("rsa.publicKey");

    public static void main(String[] args) throws Exception {
        try {
            RSAEncryptor rsaEncryptor = new RSAEncryptor(private_key, public_key);

            TreeMap<String, Object> map = new TreeMap<String, Object>();
            map.put("password", "a111111");
            map.put("payMoney", "1");
            map.put("shopCostId", "14c22a08b55411e7877eb8975ae0b849");
            //String data = "{\"password\":\"a111111\",\"payMoney\":\"1\",\"shopCostId\":\"14c22a08b55411e7877eb8975ae0b849\"}";
//            String encrypt = rsaEncryptor.encryptWithBase64(JSONUtil.toJSONStringUnExpception(map));
            //String encrypt = rsaEncryptor.encryptWithBase64(data);
            //System.out.println(encrypt);
            //参数内容  就是  data = encrypt
            //encrypt = "mnJyNTCaS8/R9NZTXzGmHKsFvRCOtvb3kEaAmVyh8u5Vf1RV4f1BzOdllVUM6MCAoN+YJnARhsAHuqc5kSVGBSSTXipEzUOrNIgVOuz7X3tRoC986Ak2XsuVRl2EZebudkDgQaIkbu6Cws9R2PWA7cW7xdCS5xFupXl/HHBI4Rg=";
            //encrypt = "dODJ+eTka+QeHOuC+JA9bWKv7LZch8QjrpgYRfhW2HtqrFcHebGXxidnFE7Zjz2HDreAliaBw7grfrbV5MCuX4L8kq+FnY/iBTm1SdNPYk4gjthLoEbZXjt71GzXgPtTC5mm9Myh9Z9LTDCT+08XQW5Z5FKsWGdIMygDTtufozU=";
//            String decrypt = rsaEncryptor.decryptWithBase64(encrypt);
//            System.out.println("\nEncrypt: \n" + encrypt);
//            System.out.println("\nDecrypt: \n" + decrypt);
            //JSONObject json = JSONObject.parseObject(test);
            //System.out.println(json);
            //System.out.println(json.get("password").toString());
            // NSLog the encrypt string from Xcode , and paste it here.
            //请粘贴来自IOS端加密后的字符串
            // String encrypt = "PXIt/lIyWr/Zk1wnBfGUiCtBIWuq0ImBre9aXcTcPb8PniX+vCKZOPRVP5rDt7C32xUPUgWyuNl1XwgR7r1R2TiqB47+s6a7CUqAHdkMDLzuRWnQJNRTbUrb2za/7c0DnhFUugju5mkdaIhL+QJ7dSVGmaYYcV1GxUyp7gEo1ac=";
            //String decryptIos=  decryptIosWithPwd(encrypt);
            //System.out.println("Decrypt result from ios client: \n" + decryptIos);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * 解密参数
     *
     * @param encrypt IOS加密后的密文
     * @return decryptStringFromIOS 解密后的String字串
     * @throws Exception
     */
    public static String decryptIosWithPwd(String encrypt) throws Exception {
        RSAEncryptor rsaEncryptor = new RSAEncryptor(private_key, public_key);
        String decryptStringFromIOS = rsaEncryptor.decryptWithBase64(encrypt);
        return decryptStringFromIOS;
    }


    /**
     * @param private_key
     * @param public_key
     * @throws Exception
     * @author zhangli
     */
    private RSAEncryptor(String private_key, String public_key) throws Exception {
        loadPublicKey(public_key);
        loadPrivateKey(private_key);
    }

    private RSAEncryptor() throws Exception {
        // load the PublicKey and PrivateKey manually
        this(private_key, public_key);
    }

    private static RSAEncryptor rsaEncryptor;

    public static RSAEncryptor getInstance() {
        if (rsaEncryptor == null) {
            try {
                rsaEncryptor = new RSAEncryptor();
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
        return rsaEncryptor;
    }


    /**
     * 获取文件地址里的文本内容
     *
     * @param filePath
     * @return
     * @throws Exception
     */
    public String getKeyFromFile(String filePath) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath));

        String line = null;
        List<String> list = new ArrayList<String>();
        while ((line = bufferedReader.readLine()) != null) {
            list.add(line);
        }

        // remove the firt line and last line
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 1; i < list.size() - 1; i++) {
            stringBuilder.append(list.get(i)).append("\r");
        }

        String key = stringBuilder.toString();
        return key;
    }

    /**
     * 解密密文为字串
     *
     * @param base64String
     * @return
     * @throws Exception
     */
    public String decryptWithBase64(String base64String) throws Exception {
        //  http://commons.apache.org/proper/commons-codec/ : org.apache.commons.codec.binary.Base64
        // sun.misc.BASE64Decoder
        byte[] binaryData = decrypt(getPrivateKey(), Base64Utils.decode(base64String)/*org.apache.commons.codec.binary.Base64.decodeBase64(base46String.getBytes())*/);
        String string = new String(binaryData);
        return string;
    }

    /**
     * 加密字串为密文
     *
     * @param string
     * @return
     * @throws Exception
     */
    public String encryptWithBase64(String string) throws Exception {
        //  http://commons.apache.org/proper/commons-codec/ : org.apache.commons.codec.binary.Base64
        // sun.misc.BASE64Encoder
        byte[] binaryData = encrypt(getPublicKey(), string.getBytes());
        String base64String = Base64Utils.encode(binaryData) /* org.apache.commons.codec.binary.Base64.encodeBase64(binaryData) */;
        return base64String;
    }


    // convenient properties
    public static RSAEncryptor sharedInstance = null;

    public static void setSharedInstance(RSAEncryptor rsaEncryptor) {
        sharedInstance = rsaEncryptor;
    }

    /**
     * 私钥
     */
    private RSAPrivateKey privateKey;

    /**
     * 公钥
     */
    private RSAPublicKey publicKey;

    /**
     * 获取私钥
     *
     * @return 当前的私钥对象
     */
    public RSAPrivateKey getPrivateKey() {
        return privateKey;
    }

    /**
     * 获取公钥
     *
     * @return 当前的公钥对象
     */
    public RSAPublicKey getPublicKey() {
        return publicKey;
    }

    /**
     * 随机生成密钥对
     */
    public void genKeyPair() {
        KeyPairGenerator keyPairGen = null;
        try {
            keyPairGen = KeyPairGenerator.getInstance("RSA");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        keyPairGen.initialize(1024, new SecureRandom());
        KeyPair keyPair = keyPairGen.generateKeyPair();
        this.privateKey = (RSAPrivateKey) keyPair.getPrivate();
        this.publicKey = (RSAPublicKey) keyPair.getPublic();
    }

    /**
     * 从文件中输入流中加载公钥
     *
     * @param in 公钥输入流
     * @throws Exception 加载公钥时产生的异常
     */
    public void loadPublicKey(InputStream in) throws Exception {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            String readLine = null;
            StringBuilder sb = new StringBuilder();
            while ((readLine = br.readLine()) != null) {
                if (readLine.charAt(0) == '-') {
                    continue;
                } else {
                    sb.append(readLine);
                    sb.append('\r');
                }
            }
            loadPublicKey(sb.toString());
        } catch (IOException e) {
            throw new Exception("公钥数据流读取错误");
        } catch (NullPointerException e) {
            throw new Exception("公钥输入流为空");
        }
    }

    /**
     * 从字符串中加载公钥
     *
     * @param publicKeyStr 公钥数据字符串
     * @throws Exception 加载公钥时产生的异常
     */
    public void loadPublicKey(String publicKeyStr) throws Exception {
        try {
            // BASE64Decoder base64Decoder= new BASE64Decoder();
            Base64Utils base64Decoder = new Base64Utils();
            byte[] buffer = base64Decoder.decode(publicKeyStr);
            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
            X509EncodedKeySpec keySpec = new X509EncodedKeySpec(buffer);
            this.publicKey = (RSAPublicKey) keyFactory.generatePublic(keySpec);
        } catch (NoSuchAlgorithmException e) {
            throw new Exception("无此算法");
        } catch (InvalidKeySpecException e) {
            throw new Exception("公钥非法");
        } catch (NullPointerException e) {
            throw new Exception("公钥数据为空");
        }
    }

    /**
     * 从文件中加载私钥
     *
     * @param in 私钥文件名
     * @return 是否成功
     * @throws Exception
     */
    public void loadPrivateKey(InputStream in) throws Exception {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            String readLine = null;
            StringBuilder sb = new StringBuilder();
            while ((readLine = br.readLine()) != null) {
                if (readLine.charAt(0) == '-') {
                    continue;
                } else {
                    sb.append(readLine);
                    sb.append('\r');
                }
            }
            loadPrivateKey(sb.toString());
        } catch (IOException e) {
            throw new Exception("私钥数据读取错误");
        } catch (NullPointerException e) {
            throw new Exception("私钥输入流为空");
        }
    }

    public void loadPrivateKey(String privateKeyStr) throws Exception {
        try {
            //BASE64Decoder base64Decoder= new BASE64Decoder();  
            Base64Utils base64Decoder = new Base64Utils();
            byte[] buffer = base64Decoder.decode(privateKeyStr);
            PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(buffer);
            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
            this.privateKey = (RSAPrivateKey) keyFactory.generatePrivate(keySpec);
        } catch (NoSuchAlgorithmException e) {
            throw new Exception("无此算法");
        } catch (InvalidKeySpecException e) {
            e.printStackTrace();
            throw new Exception("私钥非法");
        } catch (NullPointerException e) {
            throw new Exception("私钥数据为空");
        }
    }

    public static final String RSA_TYPE = "RSA/None/PKCS1Padding";//加密方式

    /**
     * 加密过程
     *
     * @param publicKey     公钥
     * @param plainTextData 明文数据
     * @return
     * @throws Exception 加密过程中的异常信息
     */
    public byte[] encrypt(RSAPublicKey publicKey, byte[] plainTextData) throws Exception {
        if (publicKey == null) {
            throw new Exception("加密公钥为空, 请设置");
        }
        Cipher cipher = null;
        try {
            cipher = Cipher.getInstance(RSA_TYPE);//, new BouncyCastleProvider());
            cipher.init(Cipher.ENCRYPT_MODE, publicKey);
            byte[] output = cipher.doFinal(plainTextData);
            return output;
        } catch (NoSuchAlgorithmException e) {
            throw new Exception("无此加密算法");
        } catch (NoSuchPaddingException e) {
            e.printStackTrace();
            return null;
        } catch (InvalidKeyException e) {
            throw new Exception("加密公钥非法,请检查");
        } catch (IllegalBlockSizeException e) {
            throw new Exception("明文长度非法");
        } catch (BadPaddingException e) {
            throw new Exception("明文数据已损坏");
        }
    }

    /**
     * 解密过程
     *
     * @param privateKey 私钥
     * @param cipherData 密文数据
     * @return 明文
     * @throws Exception 解密过程中的异常信息
     */
    public byte[] decrypt(RSAPrivateKey privateKey, byte[] cipherData) throws Exception {
        if (privateKey == null) {
            throw new Exception("解密私钥为空, 请设置");
        }
        Cipher cipher = null;
        try {
            cipher = Cipher.getInstance(RSA_TYPE);//, new BouncyCastleProvider());
            cipher.init(Cipher.DECRYPT_MODE, privateKey);
            byte[] output = cipher.doFinal(cipherData);
            return output;
        } catch (NoSuchAlgorithmException e) {
            throw new Exception("无此解密算法");
        } catch (NoSuchPaddingException e) {
            e.printStackTrace();
            return null;
        } catch (InvalidKeyException e) {
            throw new Exception("解密私钥非法,请检查");
        } catch (IllegalBlockSizeException e) {
            throw new Exception("密文长度非法");
        } catch (BadPaddingException e) {
            throw new Exception("密文数据已损坏");
        }
    }


    /**
     * 字节数据转字符串专用集合
     */
    private static final char[] HEX_CHAR = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    /**
     * 字节数据转十六进制字符串
     *
     * @param data 输入数据
     * @return 十六进制内容
     */
    public static String byteArrayToString(byte[] data) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < data.length; i++) {
            //取出字节的高四位 作为索引得到相应的十六进制标识符 注意无符号右移  
            stringBuilder.append(HEX_CHAR[(data[i] & 0xf0) >>> 4]);
            //取出字节的低四位 作为索引得到相应的十六进制标识符  
            stringBuilder.append(HEX_CHAR[(data[i] & 0x0f)]);
            if (i < data.length - 1) {
                stringBuilder.append(' ');
            }
        }
        return stringBuilder.toString();
    }

}
 