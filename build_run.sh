#bash
cd email-service
./mvnw clean package
cd ..
cd subscription-service
./mvnw clean package
cd ..
cd public-service
./mvnw clean package
cd ..
docker-compose -f docker-compose.yml up
