# Gradle Test Project: BuildItBigger

Project built for [Udacity's Android Nanodegree](https://www.udacity.com/course/android-developer-nanodegree-by-google--nd801).

App that uses Java and Android libraries to display jokes retrieved from a Google Cloud Endpoints. 
It has two flavours: a free and a paid version. The free version displays banner and interstitial ads.

The final app has four modules:
- app: Android app that fetches jokes from the GCE module and passes them to the Android Library for display.
- backend: Google Cloud Endpoints module retrieving the jokes from javaJokes
- javaJokes: Java library providing jokes.
- jokedisplay: Android library displaying the jokes in a new activity.

It also includes a connected test verifying that the async task is indeed loading jokes.


## How to install

### Step 1
Clone the repository using git (or download it as a zip), then import the project in Android Studio.
```
git clone https://github.com/ootahiaoo/GradleTestProject.git
```

### Step 2
Before going ahead you will need to be able to run a local instance of the GCE 
server. In order to do that you will have to install the Cloud SDK:

https://cloud.google.com/sdk/docs/

Once installed, you will need to follow the instructions in the Setup Cloud SDK
section at:

https://cloud.google.com/endpoints/docs/frameworks/java/migrating-android

**Note:** _You do not need to follow the rest of steps in the migration guide, only
the Setup Cloud SDK._

Start or stop your local server by using the gradle tasks as shown in the following
screenshot:

<img src="/GradleTestProject/GCE-server-gradle-tasks.png" height="500">

Once your local GCE server is started you should see the following at 
[localhost:8080](http://localhost:8080)

<img src="https://raw.githubusercontent.com/GoogleCloudPlatform/gradle-appengine-templates/77e9910911d5412e5efede5fa681ec105a0f02ad/doc/img/devappserver-endpoints.png">

### Step 3
Once your local GCE server is ready, choose a flavor test from the `Build Variants` panel, then run the app on an emulator.


## License
_To be added._
