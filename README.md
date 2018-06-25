## Denis Gallo (194441) | denis.gallo@studenti.unitn.it
**Heroku Host URL:** https://sdeproject-musicdb.herokuapp.com/  
**Heroku WSDL URL:** https://sdeproject-musicdb.herokuapp.com/centrallogic?wsdl  
**Github repositories of the project:**  
https://github.com/Intro2SDEpj-YourGamesYourMusic/MusicDB  
https://github.com/Intro2SDEpj-YourGamesYourMusic/SpotifyLayer   
I worked with Mattia Buffa.  

## MusicDB

This service comunicates with the database and the SpotifyLayer in order to handle all the requests about music and users of the project. The database is a persistent MYSQL database located at a free hosting site: https://www.freemysqlhosting.net/. Therefore there is no expiring data or information if the web service on heroku goes into "sleep mode".

### Description of the tasks

This service contains two packages: a main package **project** which is then divided into 6 packages **client**, **dao**, **endpoint**, **model**, **test.model** and **ws**.  
Endpoint (containing **CentralLogicPublisher.java**) is only needed for local testing and debugging.  
Initially the **CentralLogicClient.java** (in client) was used to test locally the functionality of the services like crud operations on the remote database. Then it was also used to test if wsimport worked as intended and if there was issues in the comunication between the 3 services MusicDB<-->SpotifyLayer<-->Spotify API. In the end, after pushing the MusicDB on heroku, this client was used to test everything before allowing other web services to interact with MusicDB.  
Model contains four models used as JPA tables on the database:  
**Artist.java** contains artists with an unique ID provided by Spotify and a name.  
**Song.java** contains songs with a unique ID provided by Spotify, a song name and an artist name (the two mentioned tables are NOT linked).  
**User.java** contains the users using the project. There are two fields, ID and chatID, which are related to Telegram to identify a user and the chat where the comunication between the bot and the user is happening.  
**User_likes.java** is the most interesting table, combining in a many-to-many relationship the users with artists/songs. A DB schema will be provided in the description of the project.  
In the dao sub-package the **SpotiDAO.java** class is implemented, which is the DAO for this layer. Basically there are only the crud operations for each model: getById, getAll, save, update, remove for Artist/Song/User/User_likes.  
Test.model contains a JUnit for each model to test if the crud operations of the DAO worked on a remote database with JPA.
The ws package is the main part of this service. **CentralLogic.java** is the interface, containing the definition of each method.  
The implemented methods:  
-initDB: it's a reset of the database.   
-crud operations create/get/delete/getAll on every model (some disabled, explained later).  
-addRating: given a user, an artist OR a song and a boolean rating (positive or negative), a rating is saved for that user and that "music element".  
-getSongsFromArtist returns 5 popular songs from an artist (which is a particular Spotify API function, explained in SpotifyLayer).  
-getLiked/getDisliked/Songs/Artists: returns all liked or disliked songs or artists given a user.
-getRecommendation: returns 5 recommended songs for a user.    
-initSong: a method to give a new user the choice of 5 predefined songs of different genres to have some background for eventual future recommendation requests.
The implementation of these methods (contained in **CentralLogicImpl.java**) are explained in the following chapter.  
**build.xml** and **ivy.xml** are almost the same used during the soap classes.    
In WebContent/WEB-INF/ there are two xml files **web.xml** and **sun-jaxws.xml** used to describe where the web services would be placed on heroku (/spoti). This technique was already used for the assignment3 to solve some weird errors which made disappear the web service on heroku.  
Credits to: https://www.mkyong.com/webservices/jax-ws/deploy-jax-ws-web-services-on-tomcat/   
In src/META-INF there is the **persistence.xml** file defining the models to be used in JPA for the database and the database coordinates. User and password are obviously censured.  
The introsde.spotifylayer.soap.ws package in the source folder is the generated one from the wsimport on the wsdl of SpotifyLayer.


### Description of the code

The following description is only about the **CentralLogicImpl.java** class since the previously mentioned classes do not require further explanations.  
All the implemented methods mentioned in the previous chapter are straight-forward. But it is necessary to mention that every request to SpotifyLayer (specified by the variable **api**) return a introsde.spotifylayer.soap.ws model. Two supportive methods were created to convert from the "api model" to the "JPA model", they are called **artistDB_fromAPI** and songDB_fromAPI and are private instead of public.  
**getSong** and **getArtist** are really important in the service flow, since a lot of methods require as input an Artist or a Song. This means that an external service calling MusicDB needs to work first with the getSong and getArtist in order to call the other methods. To not be redundant getArtist and getSong calls the SpotifyLayer only if the particular song or artist are not stored in the database yet.  

## Execution
Each of the implemented methods (except the two private ones) is callable from another service and returns the required information. There is no much error handling here so it is possible that searching for wrong or non-existent artists or songs lead to a fault. This can be handled by a try-catch at the service that is calling MusicDB. It isn't elegant but simple.  
Some crud operations are disabled like creating or updating artists and songs. API requests require correct data in order to work and by allowing externals to manipulate IDs or names may break the service flow. The recommendation method can send to the SpotifyLayer a maximum of 5 preferences of a user, they are chosen randomly. It can happen that the Spotify API returns a song that is already liked by a user. This rare case is not handled.
