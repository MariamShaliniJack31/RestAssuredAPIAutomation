@Library('shared-library') _
pipeline {
	agent any
	
   	stages {
		stage('Build') {
        		steps {
				helloWorldSimple.calling '"Shalini","Monday"'
				evenOdd()
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
