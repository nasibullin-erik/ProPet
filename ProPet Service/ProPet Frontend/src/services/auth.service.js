import axios from "axios"
import api from "../configs/api"
import { setUser } from "../reducers/userReducer"

// axios.interceptors.request.use(request => {
//   console.log('Starting Request', JSON.stringify(request, null, 2))
//   return request
// })

// axios.interceptors.response.use(response => {
// console.log('Response:', JSON.stringify(response, null, 2))
// return response
// })

export const registration = (login, mail, password, repeatedPassword, country) => {
  return axios.post(api.SIGN_UP, {
    login,
    mail,
    password,
    repeatedPassword,
    country
  })
}

export const authenticate = (mail, password) => {
  return async dispatch => {
    const response = axios.post(api.SIGN_IN, {
      mail,
      password
    }).then((response) => {
      axios.post(api.GET_ACCESS_TOKEN, {}, {
        headers: {
          'refresh-token': response.data.token
        }
      }).then((resp) => {
        const user = { user: { mail: mail, refreshToken: response.data.token, accessToken: resp.data.token } }
        dispatch(setUser(user))
      })
    })
  }
}
