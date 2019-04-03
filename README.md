# Azienda!
All'interno il programma, cinque casi d'uso (UC) e il diagramma delle classi (CD).

## Descrizione: 
E' stato realizzato il sistema informativo di una azienda che gestisce un insieme di centri di formazione.
Ogni centro organizza attività giornaliere di formazione.
Ogni centro ha un nome, un indirizzo, un email, un telefono ed una capienza massima di allievi.
Di ogni attività sono di interesse il nome e la data e l’orario in cui si svolge.
Gli allievi si presentano al centro e si iscrivono per partecipare alle attività del giorno. Se sono nuovi allievi, cioè se non hanno mai partecipato a nessuna attività di formazione, vengono raccolte e registrate le loro informazioni anagrafiche (nome, cognome, email, telefono, data e luogo di nascita). Altrimenti, le informazioni anagrafiche vengono recuperate dal sistema. In ogni caso, ciascun allievo viene associato alle attività alle quali intende partecipare. L’inserimento dei dati viene fatto dal responsabile del centro.
Ogni centro ha la possibilità di visualizzare solo i dati relativi alle proprie attività.
L’azienda ha invece la possibilità di vedere i dati di tutti i centri, aggregandoli in maniera opportuna.

## Linguaggi e API:
Java, HTML, CSS, JPA, Servlet, JSP, Spring, OAuth

## Server e Database:
Apache Tomcat, PostgreSQL (pgAdmin)
