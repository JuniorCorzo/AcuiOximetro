const TOKEN = 'eyJhbGciOiJSUzI1NiJ9.eyJpc3MiOiJzZWxmIiwic3ViIjoiSnVuaW9yIiwiZXhwIjoxNzEwOTA0MDEyLCJpYXQiOjE3MDMxMjgwMTIsInNjb3BlIjoicmVhZCJ9.CTMwlXj8Iaq63wuwBYEowhB6nRbKWGm5ovRbPooZ9hDCRuMULGZfKtekwT6sezRBCZro9cZrDlHLR-KyYeGeFbCxHDY7TUk_nyJuYNIqKpoQuGGC_qwWAnFv3MN3UP_aImDi58VuuAHJNlLso9Z-J7hy74eNCfapIPbrqdVCer76wnDtu6Nhm8bSwuHMm-XlzvOb2wt67KBKWoXY43Fp2F3JD79fRUivlYMN7pd7S5cUPzyv5CPu_h7bAcRsTKsslCGxEqjCz90x61wrkK58UTpCPuafE4Ynrn-OvMooewpLo-1zOmxKSA24ckg38eSKQGZqqk_lwDjkmnCGCZoUaA'

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
