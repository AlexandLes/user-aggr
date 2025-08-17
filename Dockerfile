# Используем Java 17 с Alpine
FROM eclipse-temurin:17-jdk-alpine

# Рабочая директория
WORKDIR /app

# Копируем pom и maven wrapper
COPY pom.xml .
COPY .mvn/ .mvn/
COPY mvnw .

# Кэшируем зависимости
RUN chmod +x mvnw
RUN ./mvnw dependency:go-offline

# Копируем исходники
COPY src ./src

# Собираем jar без тестов
RUN ./mvnw clean package -DskipTests

# Открываем порт приложения
EXPOSE 8080

# Запуск приложения
ENTRYPOINT ["java", "-jar", "target/user-test-0.0.1-SNAPSHOT.jar"]