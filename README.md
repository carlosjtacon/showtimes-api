REST API - URL SCHEME
=====================

Welcome to AlCine REST API!

- Supported languages: en, es (Other languages not tested). Spanish by default.
- The date param works this way:
  - 0 Today. (Default)
  - 1 Tomorrow.
  - 2 The day after tomorrow.

```
/theatres?location=Madrid&lang=es			        	    - Returns the list of theatres by location (madrid by default).
/theatres/{tid}?lang=es						                - Returns the geographic data of a theatre using nominatim, if available, of one tid = theatre_id.
/theatres/{tid}/films?lang=es&date=0		        		- Returns the film list of one of one tid = theatre_id.
/theatres/{tid}/films/{fid}?lang=es&date=0              	- Returns the showtimes of one tid = theatre_id and one fid = film_id.
```

```
/films?location=Madrid&lang=es&date=0				        - Returns the film list of one location.
/films/{fid}?lang=es						                - Returns the movie metadata from tmdb.
/films/{fid}/theatres?location=Madrid&lang=es&date=0		- Returns the theatres list of one fid = film_id.
/films/{fid}/theatres/{tid}?lang=es&date=0			        - Returns the showtimes of one tid = theatre_id and one fid = film_id.
```

Maven Usage:
- Install & Clean: mvn clean install.
- Generate Eclipse Struct & Dependencies: mvn eclipse:eclipse.
- Run: mvn spring-boot:run.
- Access: localhost:8080
- In order to use the 3rd party services you need to use your own API Keys.
