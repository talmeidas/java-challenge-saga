echo
echo Kill - Detran Driver License
kill -9 $(lsof -t -i:8010)

echo
echo Kill - Motor Company Automobile
kill -9 $(lsof -t -i:8020)

echo
echo Kill - Rental Company Booking
kill -9 $(lsof -t -i:8030)

echo
echo Kill - Rental Company Contract
kill -9 $(lsof -t -i:8040)

echo
echo Kill - Rental Company Support
kill -9 $(lsof -t -i:8050)

echo
echo Kill - Security Company Contract
kill -9 $(lsof -t -i:8060)

echo
echo Kill - Security Company Insurance
kill -9 $(lsof -t -i:8070)

echo
echo Kill - Saga Orchestration
kill -9 $(lsof -t -i:8000)
