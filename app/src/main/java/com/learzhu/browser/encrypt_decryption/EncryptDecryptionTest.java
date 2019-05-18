package com.learzhu.browser.encrypt_decryption;

/**
 * EncryptDecryptionTest.java是液总汇的类。
 *
 * @author Learzhu
 * @version 2.0.0 2018-01-30 09:54
 * @update Learzhu 2018-01-30 09:54
 * @updateDes
 * @include {@link }
 * @used {@link }
 */
public class EncryptDecryptionTest {
    public static void main(String args[]) {
        String resource = "Taiei9DcLFxYDdRHzfEFIHAlFJdTpkrJw8aTy+f5CufsswkXIutYSqSqnieKNX5R8mwUKvvOD6ZBT+kIXP2Ib5K0QLIdgyG9tZ/fy1z8IJkuZGT6o9OyMhuCPJc6gDYBcj/J1mTCvZubBy2zTgEe69O6gxhK5wBSbFb83Va+Slg=";
        String encode = Base64Utils.encode(resource.getBytes());
        System.out.println(encode);
    }
}
