# Basic Web Automation

The idea of this project is to help you start doing automation for web sites.

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes. See deployment for notes on how to deploy the project on a live system.

### Prerequisites
Things you need to install
*  Java jdk  with JAVA_HOME enviroment varibale configurer.
    * [Windows](https://stackoverflow.com/questions/2619584/how-to-set-java-home-on-windows-7/)
    * [Linux](https://stackoverflow.com/questions/24641536/how-to-set-java-home-in-linux-for-all-users)
    * [Mac](https://stackoverflow.com/questions/1348842/what-should-i-set-java-home-to-on-osx)
*  Mozilla Firefox [(47.0.2)](https://ftp.mozilla.org/pub/firefox/releases/47.0.2/)
*  Gitbash [(Only if using windows)](https://git-for-windows.github.io/)
* IntelliJ IDEA [(Community Version)](https://www.jetbrains.com/idea/download)

### Installing

Clone this repo:

```
git clone https://github.com/fifernandez/basic-web-automation.git
```

Navigate to the repo folder and run

```
./gradlew build idea
```

Run IntelliJ and before opening the proyect
```
click on configure -> project defaults -> project structure.
Inside project sdk click on new and search the folder where you installed java sdk, and click on Ok.
Now go to configure -> plugins -> install jetbrains plugins.
Search cucumber for groovy and isntall it with all the other required plugins that intellij informs.
Close and restart when prompted.
```

Now lets open the project in IntelliJ
```
Click on open, search for the project folder and click on ok.
Wait for loading.
Click on import gradle project and click on ok.
Wait for loading.
On the menu bar clin on view -> tool windows -> project
folders : features and groovy must be marked as test sources root (green)
folders: resources must be marked as test resources root (yellow icon)
```

## Running the tests
Inside the project folder run:
```
./gradlew cucumber
```

### Especial parameters

Explain what these tests test and why

```
Give an example
```

### And coding style tests

Explain what these tests test and why

```
Give an example
```

## Built With

* [Cucumber](https://cucumber.io/) - For writing the tests scenarios
* [Geb](http://www.gebish.org/) - For the browser automation
* [Groovy](http://groovy-lang.org/) - For writing the steps implementations
* [Gradle](https://gradle.org/) - For building and running

## Contributing

Please read [CONTRIBUTING.md](https://gist.github.com/PurpleBooth/b24679402957c63ec426) for details on our code of conduct, and the process for submitting pull requests to us.

## Versioning

We use [SemVer](http://semver.org/) for versioning. For the versions available, see the [tags on this repository](https://github.com/your/project/tags).

## Authors

* **Fran Fernandez** - [fifernandez](https://github.com/fifernandez)

See also the list of [contributors](https://github.com/fifernandez/basic-web-automation) who participated in this project.

## License

This project is licensed under the MIT License - see the [LICENSE.md](LICENSE.md) file for details

## Acknowledgments

*