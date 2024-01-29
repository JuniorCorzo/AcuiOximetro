import { useState, useEffect } from 'react'

const TOKEN = 'eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzM4NCJ9.eyJyb2xlIjoiQURNSU5JU1RSQURPUiIsInBlcm1pc3Npb25zIjpbeyJhdXRob3JpdHkiOiJNT0RJRllJTkcifSx7ImF1dGhvcml0eSI6IlJFQUQifSx7ImF1dGhvcml0eSI6IlJPTEVfQURNSU5JU1RSQURPUiJ9XSwibmFtZSI6IkFuZ2VsIiwic3ViIjoiQW5nZWwiLCJpYXQiOjE3MDQ2ODE0NDIsImV4cCI6MTcxMjQ1NzQ0Mn0.0XpFr6osBVAgx0KJ2H2ZJeDkTI6PmLq3Rk-anNlvHfZnbxY4wr7_2EWo2ICpJGrL'

export function useFetch (url, refreshKey) {
  const [data, setData] = useState(null)
  const [loading, setLoading] = useState(true)
  const [error, setError] = useState(null)

  useEffect(() => {
    fetch(url, {
      method: 'GET',
      headers: {
        Authorization: 'Bearer ' + TOKEN,
        'Content-Type': 'application/json'
      }

    })
      .then((res) => res.json())
      .then((data) => setData(data))
      .catch((err) => setError(err))
      .finally(() => setLoading(false))
  }, [refreshKey])

  return { data, loading, error }
}
