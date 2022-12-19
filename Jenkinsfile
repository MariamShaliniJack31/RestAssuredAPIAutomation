@Library('shared-library')

pipeline {
	agent any

   	stages {
		stage('Build') {
        		steps {
				sh '''
        			#!/bin/bash
				echo "hello world"
				mvn -B compile
				'''
				vars.helloWorldSimple("Shalini", "Monday")
			}
		}
      	
		stage('Test'){
    			steps{
        			sh 'mvn -B clean install'
			}
      		}
      	}
}
