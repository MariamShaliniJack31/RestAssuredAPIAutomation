pipeline {
   agent any

   stages {
		stage('Build') {
        	steps {
            	bat 'mvn -B compile'
         	}
		}
      
      	stage('Test'){
        	steps{
            	bat 'mvn -B clean install'
			}
      	}
	}
}