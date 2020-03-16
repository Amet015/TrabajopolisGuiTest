pipeline {
  agent any
    triggers {
		pollSCM('* * * * *')
    }
  stages {
        stage('BUILD') {
            steps {
                bat 'gradle build'
            }
        }
        stage('TEST') {
            steps {
                bat './gradlew executeFeatures'
            }
        }
    }
}