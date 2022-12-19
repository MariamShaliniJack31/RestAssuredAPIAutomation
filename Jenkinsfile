@Library('shared-library') _
pipeline {
	agent any

   	stages {
		stage('Build') {
        		steps {
				helloWorldSimple("Shalini", "Monday")
				echo evenOdd()
				echo "hello world"
				bat 'mvn -B compile'
				
			}
		}
      	
		stage('Test'){
    			steps {
        			bat 'mvn -B clean install'
			}
      		}
      	}
}
