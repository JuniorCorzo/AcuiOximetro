import React from 'react'
import { useFonts } from 'expo-font'
import { View, TextInput, StyleSheet } from 'react-native'

const inputText = ({ placeholder, secure }) => {
  const [fontsLoaded] = useFonts({
    'HindVadodara-Medium': require('../../assets/fonts/HindVadodara-Medium.ttf')
  })

  if (!fontsLoaded) return null

  return (
    <View>
      <TextInput
        style={styles.input}
        placeholder={placeholder}
        secureTextEntry={secure}
      />
    </View>
  )
}

const styles = StyleSheet.create({
  input: {
    paddingLeft: 8,
    height: 50,
    borderColor: 'black',
    borderWidth: 1,
    borderRadius: 5,
    fontFamily: 'HindVadodara-Medium'
  }
})

export default inputText
