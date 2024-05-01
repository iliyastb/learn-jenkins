node("workstation") {

  properties([
    paramerters([
      string(name: 'PERSON', defaultValue: 'Mr Jenkins', description: 'Environment')
    ])
  ])

  env.SAMPLE_URL = "google.com"
  try {
    withCredentials([usernameColonPassword(credentialsId: "ssh", variable: "USERPASS")]) {
      stage("one") {
        echo "one"
        sh "env"
        sh "env >/tmp/env"
      }
    }

    stage("two") {
      echo "two"
    }
  } catch (e) {
    stage ("Declarative: post actions") {
      echo "This will run only if failed"
    }
  }
}