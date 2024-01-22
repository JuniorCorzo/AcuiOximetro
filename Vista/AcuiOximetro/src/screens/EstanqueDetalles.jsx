import React from 'react'
import { View, ScrollView, Text, Pressable, StyleSheet } from 'react-native'
import Icons from '@expo/vector-icons/MaterialIcons'
import Constantes from 'expo-constants'

import EstanqueTable from '../components/EstanqueTable'
import TableNivelOxigeno from '../components/TableNivelOxigeno'
import Button from '../components/Buttons'

const EstanqueDetalles = ({ route, navigation }) => {
  const { estanque } = route.params

  return (
    <ScrollView>
      <View style={styles.container}>
        <View>
          <Pressable style={styles.header} onPress={() => navigation.goBack()}>
            <Icons name='arrow-back-ios' size={30} color='#000' />
            <Text style={styles.title}>INFORMACION DEL ESTANQUE {estanque.id}</Text>
          </Pressable>
        </View>
        <View>
          <View style={styles.imageContainer} />
        </View>
        <View style={styles.containerButtons}>
          <View style={styles.buttons}>
            <Button text='Modificar' onPress={() => navigation.navigate('ModificarEstanque')} />
          </View>
          <View style={styles.buttons}>
            <Button text='Eliminar' />
          </View>
        </View>
        <View style={styles.containerTableOxigeno}>
          <EstanqueTable estanque={estanque} />
        </View>
        <View>
          <Text>Estadisticas</Text>
        </View>
        <View style={styles.containerTableOxigeno}>
          <TableNivelOxigeno nivelesOxigeno={nivelesOxigeno} />
        </View>
      </View>
    </ScrollView>
  )
}

const styles = StyleSheet.create({
  container: {
    backgroundColor: '#FFF',
    flex: 1,
    paddingTop: Constantes.statusBarHeight + 20,
    alignItems: 'center',
    gap: 25
  },
  header: {
    flexDirection: 'row',
    alignItems: 'center',
    gap: 10
  },
  title: {
    fontSize: 25,
    textAlign: 'center'
  },
  imageContainer: {
    width: 250,
    height: 250,
    borderWidth: 1,
    borderRadius: 5,
    justifyContent: 'center',
    alignItems: 'center'
  },
  containerButtons: {
    width: 350,
    flexDirection: 'row',
    justifyContent: 'space-between',
    gap: 10
  },
  buttons: {
    width: 170
  },
  containerTableOxigeno: {
    width: 360
  }

})

const nivelesOxigeno = [
  { hora: '00:00', nivelOxigeno: 20.24 },
  { hora: '00:30', nivelOxigeno: 20.46 },
  { hora: '01:00', nivelOxigeno: 20.91 },
  { hora: '01:30', nivelOxigeno: 21.24 },
  { hora: '02:00', nivelOxigeno: 20.87 },
  { hora: '02:30', nivelOxigeno: 20.56 },
  { hora: '03:00', nivelOxigeno: 21.01 },
  { hora: '03:30', nivelOxigeno: 20.93 },
  { hora: '04:00', nivelOxigeno: 20.78 },
  { hora: '04:30', nivelOxigeno: 21.01 },
  { hora: '05:00', nivelOxigeno: 20.50 },
  { hora: '05:30', nivelOxigeno: 21.10 },
  { hora: '06:00', nivelOxigeno: 20.61 },
  { hora: '06:30', nivelOxigeno: 20.82 },
  { hora: '07:00', nivelOxigeno: 20.48 },
  { hora: '07:30', nivelOxigeno: 20.81 },
  { hora: '08:00', nivelOxigeno: 20.72 },
  { hora: '08:30', nivelOxigeno: 20.48 },
  { hora: '09:00', nivelOxigeno: 20.19 },
  { hora: '09:30', nivelOxigeno: 20.37 },
  { hora: '10:00', nivelOxigeno: 20.76 },
  { hora: '10:30', nivelOxigeno: 20.55 },
  { hora: '11:00', nivelOxigeno: 20.37 },
  { hora: '11:30', nivelOxigeno: 20.76 },
  { hora: '12:00', nivelOxigeno: 20.18 },
  { hora: '12:30', nivelOxigeno: 19.83 },
  { hora: '13:00', nivelOxigeno: 19.45 },
  { hora: '13:30', nivelOxigeno: 19.84 },
  { hora: '14:00', nivelOxigeno: 19.53 },
  { hora: '14:30', nivelOxigeno: 19.21 },
  { hora: '15:00', nivelOxigeno: 19.64 },
  { hora: '15:30', nivelOxigeno: 19.99 },
  { hora: '16:00', nivelOxigeno: 19.62 },
  { hora: '16:30', nivelOxigeno: 19.37 },
  { hora: '17:00', nivelOxigeno: 19.13 },
  { hora: '17:30', nivelOxigeno: 19.35 },
  { hora: '18:00', nivelOxigeno: 19.73 },
  { hora: '18:30', nivelOxigeno: 19.95 },
  { hora: '19:00', nivelOxigeno: 20.36 },
  { hora: '19:30', nivelOxigeno: 20.13 },
  { hora: '20:00', nivelOxigeno: 19.75 },
  { hora: '20:30', nivelOxigeno: 20.06 },
  { hora: '21:00', nivelOxigeno: 19.79 },
  { hora: '21:30', nivelOxigeno: 19.49 },
  { hora: '22:00', nivelOxigeno: 19.78 },
  { hora: '22:30', nivelOxigeno: 20.10 },
  { hora: '23:00', nivelOxigeno: 19.73 },
  { hora: '23:30', nivelOxigeno: 19.47 }
]

export default EstanqueDetalles
