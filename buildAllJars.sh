export JAVA_HOME='/Users/meriam/.sdkman/candidates/java/17.0.1-tem'
cd /Users/meriam/Desktop/Micro/eureka-service
./gradlew bootJar

cd /Users/meriam/Desktop/Micro/customer-service
./gradlew bootJar

cd /Users/meriam/Desktop/Micro/billing-service
./gradlew bootJar

cd /Users/meriam/Desktop/Micro/dref-gateway
./gradlew bootJar
