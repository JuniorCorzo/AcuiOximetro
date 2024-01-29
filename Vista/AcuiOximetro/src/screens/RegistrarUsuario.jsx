import React, { useState } from 'react'
import { View, ScrollView, Text, Pressable, KeyboardAvoidingView, Keyboard, StyleSheet } from 'react-native'
import Constantes from 'expo-constants'
import CheckBox from 'expo-checkbox'

import InputText from '../components/Input'
import Button from '../components/Buttons'
import { verticaScale, horizontalScale, moderateScale } from '../utils/Metrics'

const RegistrarUsuario = ({ navigation }) => {
  const [isSelected, setSelection] = useState(false)
  return (
    <ScrollView>
      <View style={{ gap: 20, alignItems: 'center' }}>
        <KeyboardAvoidingView
          behavior='position'
          keyboardVerticalOffset={Constantes.statusBarHeight}
        >
          <Pressable
            onPress={() => Keyboard.dismiss()}
            style={{ gap: 60 }}
          >
            <View style={styles.header}>
              <Text style={styles.name}>AcuiOximetro</Text>
            </View>
            <View style={styles.main}>
              <Text style={styles.subtitle}>REGISTRAR USUARIO</Text>
              <View style={styles.seccionForm}>
                <InputText placeholder='N° de Documento' />
                <InputText placeholder='Nombre' />
                <InputText placeholder='Apellido' />
                <InputText placeholder='Correo' />
                <InputText placeholder='Contrasena' />
                <InputText placeholder='Confirmar Contrasena' />
                <Pressable onPress={() => { setSelection(!isSelected) }}>
                  <View style={styles.containerCheckBox}>
                    <CheckBox
                      value={isSelected}
                      onValueChange={setSelection}
                      style={styles.checkbox}
                      color={isSelected ? '#000' : undefined}
                    />
                    <Text style={styles.label}>Administrador</Text>
                  </View>
                </Pressable>
                <Button text='REGISTRAR' />
              </View>
            </View>
          </Pressable>
        </KeyboardAvoidingView>
        <View style={{ alignItems: 'flex-end', width: horizontalScale(350) }}>
          <View style={{ width: horizontalScale(150) }}>
            <Button text='Volver' onPress={() => navigation.goBack()} />
          </View>
        </View>
      </View>
    </ScrollView>

  )
}

const styles = StyleSheet.create({
  header: {
    paddingTop: Constantes.statusBarHeight,
    height: verticaScale(180),
    justifyContent: 'flex-end'
  },
  main: {
    alignItems: 'center',
    gap: 20
  },
  seccionForm: {
    width: horizontalScale(300),
    gap: 15
  },
  containerCheckBox: {
    flexDirection: 'row',
    alignItems: 'center',
    gap: 10
  },
  checkbox: {
    width: 25,
    height: 25,
    borderWidth: 1,
    borderRadius: moderateScale(5)
  },
  label: {
    fontSize: moderateScale(17)
  },
  subtitle: {
    fontSize: moderateScale(40)
  },
  name: {
    fontSize: moderateScale(70),
    textAlign: 'center'
  }
})

export default RegistrarUsuario
