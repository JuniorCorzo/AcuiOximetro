import React, { useState } from 'react'
import {
  View,
  Text,
  Pressable,
  StyleSheet
} from 'react-native'
import Icons from '@expo/vector-icons/FontAwesome'
import { useFonts } from 'expo-font'

const MenuUsuario = ({ nombre, isAdmin, navigation }) => {
  const [rotacion, setRotacion] = useState(0)
  const [visible, setVisible] = useState(false)

  const [fontsLoaded] = useFonts({
    'Poppins-Medium': require('../../assets/fonts/Poppins-Medium.ttf'),
    'HindVadodara-Medium': require('../../assets/fonts/HindVadodara-Medium.ttf')
  })
  if (!fontsLoaded) return null

  const tocarMenu = () => {
    setRotacion(rotacion === 90 ? 0 : 90)
    setVisible(!visible)
  }

  const renderAdmin = () => {
    if (isAdmin) {
      return (
        <Pressable style={styles.opciones}>
          <Text style={styles.textOpciones}>Crear Nuevo Usuario</Text>
        </Pressable>
      )
    }
  }

  const renderMenu = () => {
    if (visible) {
      return (
        <View style={styles.menuOpciones}>
          <Pressable style={styles.opciones}>
            <Text style={styles.textOpciones}>Opciones de Cuenta</Text>
          </Pressable>
          {renderAdmin()}
          <Pressable
            onPress={() => {
              navigation.navigate('Login')
            }}
          >
            <Text style={styles.textOpciones}>Cerrar Sesión</Text>
          </Pressable>
        </View>
      )
    }
  }

  return (
    <View style={styles.container}>
      <Pressable style={styles.menu} onPress={tocarMenu}>
        <Icons
          name='chevron-right'
          style={{ transform: [{ rotate: `${rotacion}deg` }] }}
          size={20}
        />
        <Text style={styles.text}>Hola, {nombre}</Text>
      </Pressable>
      <View>{renderMenu()}</View>
    </View>
  )
}

const styles = StyleSheet.create({
  container: {
    width: '85%',
    borderBottomWidth: 1,
    borderRightWidth: 1,
    borderTopRightRadius: 10,
    borderBottomRightRadius: 20,
    borderBottomLeftRadius: 20,
    paddingTop: 5,
    paddingBottom: 20,
    paddingRight: 10
  },
  menu: {
    flexDirection: 'row',
    alignItems: 'center',
    marginLeft: 15,
    gap: 20
  },
  text: {
    fontFamily: 'Poppins-Medium',
    fontSize: 20
  },
  menuOpciones: {
    marginTop: 20,
    alignItems: 'center',
    gap: 10
  },
  opciones: {
    width: '93%',
    paddingBottom: 20,
    borderBottomWidth: 1
  },
  textOpciones: {
    paddingTop: 10,
    textAlign: 'center',
    fontFamily: 'HindVadodara-Medium',
    fontSize: 15
  }
})
export default MenuUsuario
