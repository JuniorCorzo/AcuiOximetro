import React from 'react'
import Constants from 'expo-constants'
import { View, Text, StyleSheet, KeyboardAvoidingView } from 'react-native'
import Input from '../components/Input.jsx'
import Button from '../components/Buttons.jsx'
import { useFonts } from 'expo-font'

const Login = ({ navigation }) => {
  const [fontsLoaded] = useFonts({
    'Poppins-Medium': require('../../assets/fonts/Poppins-Medium.ttf')
  })

  if (!fontsLoaded) return null
  return (
    <KeyboardAvoidingView behavior='position' keyboardVerticalOffset={1} style={{ backgroundColor: '#fff' }}>
      <View style={styles.container}>
        <Text style={styles.name}>AcuiOximetro</Text>
        <View style={styles.login}>
          <Text style={styles.textLogin}>INICIAR SESION</Text>
          <Input placeholder='Usuario' />
          <Input placeholder='Contraseña' secure />
          <Button text='ACCEDER' onPress={() => navigation.navigate('Inicio')} font='QuattrocentoSans-BoldItalic' />
        </View>
      </View>
    </KeyboardAvoidingView>
  )
}

const styles = StyleSheet.create({
  container: {
    paddingTop: Constants.statusBarHeight + 197,
    paddingBottom: '100%',
    gap: 138,
    alignItems: 'center'
  },
  name: {
    textAlign: 'center',
    fontSize: 65,
    fontFamily: 'Poppins-Medium'
  },
  login: {
    gap: 17
  },
  textLogin: {
    textAlign: 'center',
    fontSize: 40,
    fontFamily: 'Poppins-Medium'
  }
})

export default Login
