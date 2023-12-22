import React from 'react'
import { Text, TouchableHighlight, StyleSheet } from 'react-native'
import { useFonts } from 'expo-font'

const Button = ({ text, onPress }) => {
  const [fontsLoaded] = useFonts({
    'QuattrocentoSans-BoldItalic': require('../../assets/fonts/QuattrocentoSans-BoldItalic.ttf')
  })

  if (!fontsLoaded) return null
  return (
    <TouchableHighlight
      style={styles.button}
      underlayColor='#FFF'
      onPress={onPress}
    >
      <Text style={styles.textButton}>{text}</Text>
    </TouchableHighlight>
  )
}

const styles = StyleSheet.create({
  button: {
    width: 340,
    backgroundColor: '#FFF',
    borderWidth: 1,
    borderColor: 'black',
    borderRadius: 5,
    height: 50,
    justifyContent: 'center',
    alignItems: 'center'
  },
  textButton: {
    color: 'black',
    fontSize: 20,
    fontFamily: 'QuattrocentoSans-BoldItalic',
    fontWeight: 'bold'
  }
})

export default Button
