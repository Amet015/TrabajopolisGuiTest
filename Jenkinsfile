pipeline {
  agent any
    triggers {
		pollSCM('* * * * *')
    }
  stages {
        stage('BUILD') {
            steps {
                sh 'gradle clean build'
            }
        }
        stage('TEST') {
            steps {
                sh 'gradle executeFeatures'
            }
        }
    }
}