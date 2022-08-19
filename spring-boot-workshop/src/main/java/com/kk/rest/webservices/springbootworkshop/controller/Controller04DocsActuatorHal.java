package com.kk.rest.webservices.springbootworkshop.controller;

/**
 * 1. Rest icin standart bir dokumantasyon bulunmamakta ancak swaggeri include edersek 
 *  Spring Boot'un urettigi OPENAPI specificationa gore swagger dokumani uretecektir
 * 2. Bu proje icin http://localhost:8093/swagger-ui/index.html adresinden erisilebilir
 *  Burada hangi servisler hangi parametrelerle cagriliyor, hangi validationlar var, input output obje tipleri vs belirtilmektedir
 * 3. Actuator ile metrikleri, health check vs. izelyebilmekteyiz. Burada http://localhost:8093/actuator uzerinden erisilebilmektedir
 *  http://localhost:8093/actuator/metrics/http.server.requests gibi isteklerle de detaylar goruntulenebilmektedir
 * 4. HAL Explorer ile API'nin detay bilgilerine neler icerdigine vs. erisilebilmektedir
 *  Direkt localhost:8093 adresi uzerinden erisilebilmektedir
 * @author korayk
 */
public class Controller04DocsActuatorHal {

}
