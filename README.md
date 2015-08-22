# OrientationChanges
A demo app for how to handle orientation changes on Android.

# What to Do:
You can checkout and run this app to get a better idea of what exactly is happening when you rotate an Android device.

When you run the app, you will see a screen with a list of buttons, one for each demo. The buttons with a green background are examples of what you should do, while the buttons with the regular grey backgrounds are examples of what you should avoid doing.

# The Demos:

Each of the demos demonstrates a particular concept that you should understand to be able to properly handle orientation changes.
The bold ones are __what you should do__ (equivalent to the green buttons in the actual app).

* configChanges - With the Flag
  * _When you use the android:configChanges flag on your Activity, you will be unable to use different layouts in Portrait and Landscape orientations_

* __configChanges - Without the Flag__
  * ___Without the android:configChanges flag, you will be able to use different layouts in Portrait and Landscape orientations___

* screenOrientation - With the Flag
  * _With the android:screenOrientation flag, the screen will not rotate when you rotate the device_

* Fragment Re-adding - Every Time onCreate is Called
  * _If you add your Fragment every time onCreate is called, the Fragments will be layered on top of each other after an orientation change and they will lose their state_

* __Fragment Re-adding - Only When Not Recreating the Activity__
  * ___If you only add your Fragment when savedInstanceState == null the Fragments will never be layered on top of each other and they will save their state___

* __Fragment Backstack Demo__
  * ___Demonstrates that if you follow the guidelines of the previous demo, Android will be able to properly recreate your Fragment backstack after an orientation change without you doing any work___

* __Recreating a ListView__
  * ___How to properly save and restore basic state and the state of a ListView___

* Handling AsyncTasks - Ignoring Them
  * _If you start an AsyncTask then ignore it, it will cause a memory leak when you rotate your device_

* Handling AsyncTasks - Ignoring Them V2
  * _If you start and ignore an AsyncTask which displays a ProgressDialog, then rotate the device, when the AsyncTask eventually finishes, and you attempt to dismiss the ProgressDialog, the app will crash because the old ProgressDialog is no longer attached to a window_

* __Handling AsyncTasks - Cancelling Them__
  * ___One way to avoid memory leaks and crashes is to cancel your AsyncTasks in onDestroy___

* __Handling AsyncTasks - Using a Retained Fragment__
  * ___Cancelling AsyncTasks every time the user rotates the device is less than ideal, so you can use a retained Fragment with the sole purpose of hosting your AsyncTask, so that it will survive an orientation change___

# Further Reading
You can also check out my blog post on [Handling Orientation Changes on Android](http://code.hootsuite.com/) for a more in depth look at what you should and shouldn't do with regards to orientation changes on Android
