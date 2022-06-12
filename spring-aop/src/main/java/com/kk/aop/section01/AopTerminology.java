package com.kk.aop.section01;

/**
 * 1. AOP koda functional olmayan bazi ozellikleri kodu degistirmeden eklemek icin kullanilmaktadir, bunlar cross-cutting concern olarak adlandirilmaktadir (Loglama, security gibi)
 * 2. AOP interceptor gibi calisir, metoda oncesinde sonrasinda bir ozellik eklemek vs. icin kullanilabilmektedir
 * 3. Aspect: Crosscutting concernlerinin implementasyonunu saglamaktadir (Logging Aspect, Transaction Management Aspect gibi)
 * 4. Joinpoint: Aspecti uygulamada baglamak istedigimiz noktaya denir, yani asil AOP aksiyonunun alinacagi yerdir. (Aslinda metotlar)
 * 5. Advice: Her bir JoinPoint icin alinacak aksiyonlardir.
 * 6. PointCut: Advice'in uygulanacagi birden cok JoinPoint icin kullanilan ortak yapidir 
 * 
 * @author korayk
 */
public class AopTerminology {

}
