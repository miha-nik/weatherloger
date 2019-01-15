# About Project 
Weatherlogger application to save weather conditions for your current location.

## Run application

Import the project in Android Studio. Build and run an application on a device or emulator

# Functionality

On the main screen in the toolbar, click the save button, the application sends a request to determine your location,
when the answer comes, it asks for the weather according to the current location and saves the result to the local storage.
After displays the result on the screen. Shows the temperature and weather icon, location and date of the request.

# Libraries using in application

**Retrofit2** - used in the project for requests to the network to determine the current location from http://ip-api.com/, as well as to get the weather from https://openweathermap.org/api
**Dagger2** - using to dependency injection
**Betternife** - for data binding
**Room** - for local storeje in database
**RxJava** - for reactive programming
**Picasso** - for loading and showing current weather icon

