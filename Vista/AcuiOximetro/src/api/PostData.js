const TOKEN = 'eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzM4NCJ9.eyJyb2xlIjoiQURNSU5JU1RSQURPUiIsInBlcm1pc3Npb25zIjpbeyJhdXRob3JpdHkiOiJNT0RJRllJTkcifSx7ImF1dGhvcml0eSI6IlJFQUQifSx7ImF1dGhvcml0eSI6IlJPTEVfQURNSU5JU1RSQURPUiJ9XSwibmFtZSI6IkFuZ2VsIiwic3ViIjoiQW5nZWwiLCJpYXQiOjE3MDQ2ODE0NDIsImV4cCI6MTcxMjQ1NzQ0Mn0.0XpFr6osBVAgx0KJ2H2ZJeDkTI6PmLq3Rk-anNlvHfZnbxY4wr7_2EWo2ICpJGrL'

export async function postData (url, data) {
  try {
    const response = await fetch(url, {
      method: 'POST',
      headers: {
        Authorization: 'Bearer ' + TOKEN,
        'Content-Type': 'application/json'
      },
      body: JSON.stringify(data)
    })
      .then(res => {
        if (!res.ok) {
          throw new Error(`HTTP error! status: ${res.status}`)
        }
      })

    return [null, response]
  } catch (err) {
    return [err, null]
  }
}
