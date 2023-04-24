echo
echo Install and Run - Detran Driver License
mvn clean install -Dmaven.test.skip=true -f ./detran-driver-license
mvn spring-boot:run -Dspring.profiles.active=default -f ./detran-driver-license &

echo
echo Install and Run - Motor Company Automobile
mvn clean install -Dmaven.test.skip=true -f ./motor-company-automobile
mvn spring-boot:run -Dspring.profiles.active=default -f ./motor-company-automobile &

echo
echo Install and Run - Rental Company Booking
mvn clean install -Dmaven.test.skip=true -f ./rental-company-booking
mvn spring-boot:run -Dspring.profiles.active=default -f ./rental-company-booking &

echo
echo Install and Run - Rental Company Contract
mvn clean install -Dmaven.test.skip=true -f ./rental-company-contract
mvn spring-boot:run -Dspring.profiles.active=default -f ./rental-company-contract &

echo
echo Install and Run - Rental Company Support
mvn clean install -Dmaven.test.skip=true -f ./rental-company-support
mvn spring-boot:run -Dspring.profiles.active=default -f ./rental-company-support &

echo
echo Install and Run - Security Company Contract
mvn clean install -Dmaven.test.skip=true -f ./security-company-contract
mvn spring-boot:run -Dspring.profiles.active=default -f ./security-company-contract &

echo
echo Install and Run - Security Company Insurance
mvn clean install -Dmaven.test.skip=true -f ./security-company-insurance
mvn spring-boot:run -Dspring.profiles.active=default -f ./security-company-insurance &

#echo
#echo Install and Run - Saga Orchestration
#mvn clean install -Dmaven.test.skip=true -f ./saga-orchestration
#mvn spring-boot:run -Dspring.profiles.active=default -f ./saga-orchestration &

sleep 10
echo
echo Swagger Applications
echo Saga Orchestration\\t\\t        -\> http://localhost:8000/swagger-ui/index.html
echo Detran Driver License\\t\\t     -\> http://localhost:8010/swagger-ui/index.html
echo Motor Company Automobile\\t     -\> http://localhost:8020/swagger-ui/index.html
echo Rental Company Booking\\t\\t    -\> http://localhost:8030/swagger-ui/index.html
echo Rental Company Contrac\\t\\t    -\> http://localhost:8040/swagger-ui/index.html
echo Rental Company Support\\t\\t    -\> http://localhost:8050/swagger-ui/index.html
echo Security Company Contract\\t    -\> http://localhost:8060/swagger-ui/index.html
echo Security Company Insurance\\t   -\> http://localhost:8070/swagger-ui/index.html
exit