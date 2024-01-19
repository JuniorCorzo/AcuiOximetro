const TOKEN = 'eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzM4NCJ9.eyJyb2xlIjoiQURNSU5JU1RSQURPUiIsInBlcm1pc3Npb25zIjpbeyJhdXRob3JpdHkiOiJNT0RJRllJTkcifSx7ImF1dGhvcml0eSI6IlJFQUQifSx7ImF1dGhvcml0eSI6IlJPTEVfQURNSU5JU1RSQURPUiJ9XSwibmFtZSI6IkFuZ2VsIiwic3ViIjoiQW5nZWwiLCJpYXQiOjE3MDQ2ODE0NDIsImV4cCI6MTcxMjQ1NzQ0Mn0.0XpFr6osBVAgx0KJ2H2ZJeDkTI6PmLq3Rk-anNlvHfZnbxY4wr7_2EWo2ICpJGrL'

const getSuspense = (promise) => {
  let status = 'pending'
  let response

  const suspender = promise.then(
    res => {
      status = 'success'
      response = res
    },
    err => {
      status = 'error'
      response = err
    }
  )

  const read = () => {
    switch (status) {
      case 'pending':
        throw suspender
      case 'error':
        throw response
      default:
        return response
    }
  }

  return { read }
}

export function fetchData (url) {
  const promise = fetch(url, {
    Method: 'GET',
    mode: 'cors',
    headers: {
      Authorization: 'Bearer ' + TOKEN,
      'Content-Type': 'application/json'
    }
  })
    .then(response => response.json())
    .then(data => data)

  return getSuspense(promise)
}
