/* eslint-disable react/jsx-handler-names */
import React from 'react'
import { View, ScrollView, Text, Pressable, KeyboardAvoidingView, Keyboard, StyleSheet } from 'react-native'
import Constants from 'expo-constants'
import { useFonts } from 'expo-font'

import Button from '../components/Buttons'
import FormEstanque from '../components/FormEstanque'

const ModificarEstanque = ({ navigation }) => {
  const [fontsLoaded] = useFonts({
    'Poppins-Medium': require('../../assets/fonts/Poppins-Medium.ttf')
  })

  if (!fontsLoaded) return null

  return (
    <Pressable onPress={Keyboard.dismiss}>
      <ScrollView
        showsVerticalScrollIndicator={false}
        overScrollMode='never'
      >
        <View style={{ gap: 20 }}>
          <KeyboardAvoidingView behavior='position' keyboardVerticalOffset={-90}>
            <View style={[styles.container, styles.header]}>
              <View style={{ width: '100vw' }}>
                <Text style={styles.name}>AcuiOximetro</Text>
              </View>
              <View style={styles.containerForm}>
                <Text style={styles.subTitle}>MODIFICAR ESTANQUES</Text>
                <FormEstanque />
                <View style={{ width: 320 }}>
                  <Button text='MODIFICAR' />
                </View>
              </View>
            </View>
          </KeyboardAvoidingView>
          <View style={styles.containerBotton}>
            <View style={{ width: 150 }}>
              <Button text='Volver' onPress={() => navigation.goBack()} />
            </View>
          </View>
        </View>
      </ScrollView>
    </Pressable>
  )
}

const styles = StyleSheet.create({
  header: {
    paddingTop: Constants.statusBarHeight + 180
  },
  container: {
    backgroundColor: '#FFF',
    alignItems: 'center',
    gap: 130
  },
  containerForm: {
    alignItems: 'center',
    gap: 20
  },
  containerBotton: {
    width: '95%',
    height: 100,
    alignItems: 'flex-end',
    justifyContent: 'center'
  },
  name: {
    textAlign: 'center',
    fontSize: 65,
    fontFamily: 'Poppins-Medium'
  },
  subTitle: {
    fontSize: 35
  }
})

export default ModificarEstanque
