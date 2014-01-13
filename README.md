Official Android 3.0 Application for 8tracks
============================================

###Contacts: 
Martin Marconcini - martin@8tracks.com, marconcini@gmail.com 

8tracks API Key: e7b8d8788cb321ab5d12bb2066b23c9a07c69efc

*Before building, see com.e8tracks.Config.java*

currentEnvironment: this will change the host for the api.  For example Environment.STAGING will route all requests to http://backstage.8tracks.com

mixPanelEnvironment: if you need to test stuff, it's good to route requests to the development console of mixpanel to avoid adding false info.

LOGGING = true or false. For production always use false.

BUGREPORT = true or false. Enables or disables the BUGReport tool. It's nice to disable during development. Make sure to have it on for Production.

FORCE_MIXPANEL_ENABLED_BEFORE_LOGIN = Mixpanel uses math to determine a % of users who are going to be included before they are logged into the app. This forces everyone to be included (good for debugging mixpanel). Make sure to set to false for production.

USE_PROXY, PROXY_HOST and PROXY_PORT = set these three if you want to test requests through a proxy. Please make sure this is disabled for production.


*Application signing and release builds:*

Right click project -> Android Tools -> Export Signed Application Package
See signing/application-signing.txt for key/password used to sign a release build
Be sure to test release builds, as Proguard packs and obfuscates the code, which may cause things to break.

*Other gotchas:*

The GSON json parsing library jar is repackaged with jar jar (http://code.google.com/p/jarjar/)
If upgrading the GSON jar, be sure to repackage it.
Certain devices come with GSON pre-packaged and conflicts can occur.

Checking out the Project for the first time
---
The 8tracks project doesn't really have a lot of dependencies (and most will come in the /libs folder) or will come with the pull.

I develop using IntelliJ IDEA Community Edition and not Eclipse. I'm sure it's relatively easy to import the project into Eclipse.

