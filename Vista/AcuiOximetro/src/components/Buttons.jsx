import React from 'react'
import { Text, Pressable, StyleSheet } from 'react-native'
import { useFonts } from 'expo-font'

const Button = ({ text, onPress, font }) => {
  const [fontsLoaded] = useFonts({
    'QuattrocentoSans-BoldItalic': require('../../assets/fonts/QuattrocentoSans-BoldItalic.ttf'),
    'HindVadodara-Medium': require('../../assets/fonts/HindVadodara-Medium.ttf')
  })

  if (!fontsLoaded) return null
  return (
    <Pressable
      style={styles.button}
      underlayColor='#FFF'
      onPress={onPress}
    >
      <Text style={[styles.textButton, { fontFamily: font }]}>{text}</Text>
    </Pressable>
  )
}

const styles = StyleSheet.create({
  button: {
    width: '100%',
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
    fontSize: 20
  }
})

export default Button
