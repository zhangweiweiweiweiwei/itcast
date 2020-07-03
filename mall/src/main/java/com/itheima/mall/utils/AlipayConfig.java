package com.itheima.mall.utils;

public class AlipayConfig {
//↓↓↓↓↓↓↓↓↓↓请在这里配置您的基本信息↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓

    // 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
    public static String app_id = "2016102200738681";

    // 商户私钥，您的PKCS8格式RSA2私钥
    public static String merchant_private_key = "MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQC7zHpTtCxdvOn3Kgbuiv+3dtpU+TAmm6xeOjzOwZ1wuNbFb8/ld7VRNfANNTK6XnbSkCsPNyMfjPSFXFjBO5R3AWelj7E0eji4rwpY8isGbwCrz6fPnV/Iy90gssK9xZ3bsFCqPxSRDitMpZd3EVjzAd04Fuhf3vYjn8NKU10NhdQUfxQsSt9K3FLvmwCeW3ekPKGNl+jYYF/sdvTA6lLwXQV9v0rThOoSV08/iZ9OWDJOZXXsmuaQlxaUJX9GUD4BFUblA2RvjaLmlwkBC973mDNR4fYFMN5DRsM4nAtGZzVZX1QRtWc5OC4YTDmujhH7CK9xn2sKQxD/zi1g+eUfAgMBAAECggEBAKg/RxCaiGzqhMnUsyUfDn31UyFxpjvQmBpLHpM1TrHgRznXNHAmUSESq5+Jm4rweo+mbY1SHntzstWPqExl7lq3vX3MQDv9i7eZyjFptDYtWHKUtYkBOwEP82oJ/QI7e3OIgJwlq21RPmWKrSoVNpVvhBtuGn1ZqTa9OR7rlKA5S0yQ1lgZ+xz4J1NVs8vlrnpCQ6VBxSokxg6NzIk+UuFQz/mMqUEMDHyOItF4d8xFwTPGZIvtzi3ZQXiE/bD+EwWuXaFnyePGmab0QHgQkULn5+aIFX4eSfmiOZ/NlUOUY9Hs2uGcFUu0dfFcb+ZDtz9jwWnJ4OpGmwpg6mWKosECgYEA+eBsiqssWLVQjsbK73iVTzQkj1szH233QU2ltEn1o0X0ZtrjJNb/HMt6H6pzZ6AMiO/bwq2lr4TDVPXuKRmChM8yzg0jrLOggnTn6ZeQwZMZ4aUl0ddgl/eTWaAmD+9khp0OQIqoXlVpgPHTZfzkNihB1QniUyrA2fkonw0bgi8CgYEAwGadQ27kfLwgowiRzutKKcxpdRzSh3THfThvB/G7pYaNadefkvkkapHfbgDoK0t9DijrPkwkLoctaXvLnVdH6Uv4NLROfDhqC++fRZZ9gdEtaL8gP+Hce4Y9KRv5Zlu4je/7La1xIWCRnmnykI3ICqMx3Uju4fs5QXW1NJXtwBECgYEAwt2/KAFHy0JTOZVUS57JKgRrApVH8BnM+lN4h3oqIxN5/wBypZc5SpZwfeNqroSFYgFUa6UKEjBCOK619b1cKQCBCWn7yUIoSbSr62J01FFInM0zCkuhm8HKWtnm9QRnbAdtRu4bUb3gUlvE1cN7obSRaneT1fIAhbymbitFqacCgYAKERRnY9T2pc07WoZugicWOsjFxOVLCxQo/BvrGX3M8lZR1GNYCEscfFdpZQjAwyle5UsxrkAyYwZAP6buq5NqpHvvHgQBQd5ik34M4QveD/jFQ0LHtOSZXfOzQ/Bvp5rnakgFIs8JhQj5deeoIpL144YHYvqEvmVHhIYfozyWUQKBgAKbnUt9XQSUzTmRmhUTULL9TZzVtBqA551i8+Nex4IH2UiYfeJD8THHTWu75T5aOST7FX8GnwCha5FZ1V3LARVj56COD0roAIoxIZYhP+AfWPKatCSdg2wI25ILxY7zipDZC8Wjipxs1vfoc0P0dEtAxEKMFQM2DiJBUOjXFtt7";

    // 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
    public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAkhXMkKANURz49B/Mvjlfq3peW2samOjXplKshxcWhfTa3EARN2Eun5+k/Z/QG0lG21bAWTb2UpH1uKpI8txPSh74zK14j4m5zqy1KE20qgDnqhHvs6TrA12ZcieXoqnNZeUjCBYTb0F0g/NVthmR2zXNLVeSWL7+qAQRuAb1gDjJlclwKh5YMzmrQGJ/NWofVCnOPRKhGi5GFM0Tbp2wIPr7T1tJQNarb6TnjuJV7qCHqwnqMu/Bs0hidY/ll71oqBtjHziRRc8ECBZqGicmvCds1P5HNzmB0YvfUH/8qPBvFkuoiIpVKVSWVg79nDHeYVV+ikkhLM1Gv/BxpqRhlwIDAQAB";
    // 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    public static String notify_url = "http://localhost:82/pay/alipayNotifyNotice";

    // 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    //当支付成功之后，通知我们服务（服务器必须定义一个servlet或jsp来接收apli的通知）
    public static String return_url = "http://localhost:82/pay/alipayReturnNotice";

    // 签名方式
    public static String sign_type = "RSA2";

    // 返回格式
    public static String FORMAT = "json";

    // 字符编码格式
    public static String charset = "utf-8";

    // 支付宝网关
    public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";

    // 支付宝网关日志
    public static String log_path = "F:\\支付资料\\alipay支付宝\\log";
}
