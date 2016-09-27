# teamadventure

Requirements
-----------
- Gradle 1.7
- On Mac (`brew install gradle`)
- On Windows check out `http://codetutr.com/2013/03/23/how-to-install-gradle/`

The `brew` command is available on OS X after you have installed [Homebrew]

[Homebrew]: http://brew.sh/

Initial Set Up
---------------
1. Clone this repo: `git clone https://github.com/chill5018/teamadventure.git` (if you haven't already done that)
1. Launch IntelliJ, select Open 
1. Go into the repo directory, and select: `teamadventure`, click ok


### On Windows (cmd.exe terminal)

1. Clone this repo: `git clone git clone https://github.com/chill5018/teamadventure.git` (if you haven't already done that)
1. Go into the repo directory : `cd peergrade.io`
1. Create virtualenv: `virtualenv .venv`
1. Activate virtualenv: `.venv\Scripts\activate`
1. Install Python packages: `pip install -r requirements.txt`
1. Install Python packages for developers: `pip install -r requirements_dev.txt`
1. Install npm packages: `npm install`
1. Install Bower, Browserify, Brunch, and Foreman `npm install -g bower browserify brunch foreman`
1. Install bower packages: `bower install`
1. (Optional) Install terminal-notifier (on OSX: `brew install terminal-notifier`)

Build
-----
Run

    gradle run


Build
-----
Test

    gradle test



See your hard work at http://localhost:4567/
