pipeline {
//  agent any

//  Node name agent
//  agent {
//    node { label "workstation" }
//  }

  agent {
    label "terraform"
  }

  stages {
    stage("one") {
      steps {
        echo "one"
      }
    }

    stage("two") {
      steps {
        echo "two"
      }
    }
  }

  post {
    always {
      echo 'Hello again!'
    }
  }
}