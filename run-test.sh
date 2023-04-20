echo
echo Install and Run - Detran Driver License
mvn -e clean test -Dspring.profiles.active=test -f ./detran-driver-license

echo
echo Install and Run - Motor Company Automobile
mvn -e clean test -Dspring.profiles.active=test -f ./motor-company-automobile

echo
echo Install and Run - Rental Company Booking
mvn -e clean test -Dspring.profiles.active=test -f ./rental-company-booking

echo
echo Install and Run - Rental Company Contract
mvn -e clean test -Dspring.profiles.active=test -f ./rental-company-contract

echo
echo Install and Run - Rental Company Support
mvn -e clean test -Dspring.profiles.active=test -f ./rental-company-support

echo
echo Install and Run - Security Company Contract
mvn -e clean test -Dspring.profiles.active=test -f ./security-company-contract

echo
echo Install and Run - Security Company Insurance
mvn -e clean test -Dspring.profiles.active=test -f ./security-company-insurance

echo
echo Install and Run - Saga Orchestration
mvn -e clean test -Dspring.profiles.active=test -f ./saga-orchestration
