pipeline {
  agent any
    triggers {
		pollSCM('* * * * *')
    }
  stages {
        stage('BUILD') {
            steps {
                sh './gradlew build'
            }
        }
        stage('TEST') {
            steps {
                sh './gradlew -q executeFeatures'
            }
        }
    }
}