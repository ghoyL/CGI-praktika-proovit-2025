## CGI-suvepraktika-proovitöö

### Funktsioonid

- Näitab kõik lende korraga
- Saab otsida lende asukoha ja kuupäeva järgi
- Saab istekohti valida

### Kuidas kasutada:

Enne tööle panemist veendu, et vajalikud asjad on alla laetud  
- Java  (https://www.java.com/en/download/). 
- Maven (https://maven.apache.org/install.html)
- Node.js (https://nodejs.org/)
- Postgres (https://www.postgresql.org/download/)
### Kontrolli:

```java -version ```   
```mvn -v ```  
```node --version ```  

Postgres - Windows: Ava "Services" ja otsi "PostgreSQL", kontrolli, et oleks "Running"
Linux/Mac ```sudo systemctl status postgresql```  

### Kui alla laetud, siis clone'i mu repo:  

```git clone https://github.com/ghoyL/CGI-praktika-proovit-2025.git```

 Kui Postgres töötab, pane käima back-end ja front-end.

#### 1. Loo Postgres andmebaas:

psql -U postgres

password: postgres

CREATE DATABASE flightdb;

#### 2. Backend:

```
cd backend

mvn clean-install

mvn spring-boot:run

```

#### 3. Frontend: 

```
cd frontend 

npm install

npm run dev

```
Kui npm töötab, mine: http://localhost:5173/

### Muu info

Tööd alustasin 19.märtsil.

Kõige keerulisem oli Java/Spring Boot'i kasutamine, kuna ma varem ei ole kasutanud Java/Spring Boot'i. Seetõttu on enamik Java koodist ChatGPT abiga tehtud.  

Tegemata jäi lennu otsimine hinna järgi ja koha valmimise filtrite tegemine, seega jäi töö üsna algeliseks.

### Tech stack

Frontend: Javascript, Vue.js, HTML, CSS  
Backend: Java/Spring Boot  
Database: Postgres  