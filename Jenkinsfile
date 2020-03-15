pipeline {
  agent any
    triggers {
		pollSCM('* * * * *')
    }
  stages {
        stage('BUILD') {
            steps {
                bat './gradlew build'
            }
        }
        stage('TEST') {
            steps {
                bat './gradlew executeFeatures'
            }
        }
    }
}