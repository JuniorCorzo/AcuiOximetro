import React from 'react'
import Constants from 'expo-constants'
import { View, ScrollView, Text, StyleSheet } from 'react-native'

import MenuUsuario from '../components/MenuUsuario.jsx'
import Estanques from '../components/Estanques.jsx'
import Button from '../components/Buttons.jsx'
import { useFetch } from '../api/UseFetch.js'

const Inicio = ({ navigation }) => {
  const { data, error, loading } = useFetch(`http://${Constants.expoConfig.extra.hostApi}:8080/api/v1/estanques/${1}`)

  return (
    <View style={[styles.header, styles.container]}>
      <MenuUsuario nombre='Angel' isAdmin navigation={navigation} />
      <ScrollView
        showsVerticalScrollIndicator={false}
        overScrollMode='never'
        contentContainerStyle={{ paddingBottom: 90 }}
      >
        <View style={styles.container}>
          <Text style={styles.title}>Estanques</Text>
          <View style={styles.containerEstanques}>
            <Button text='Añadir Estanque' onPress={() => navigation.navigate('AñadirEstanque')} font='HindVadodara-Medium' />
          </View>
          <View style={styles.containerEstanques}>
            {error && <Text>Error al cargar los estanques</Text>}
            {loading && <Text>Cargando...</Text>}
            {data?.map((estanque) => (
              <Estanques key={estanque.id} nombre={'Estanque ' + estanque.id} onPress={() => navigation.navigate('EstanqueDetalles', { estanque })} />
            ))}
          </View>
          <View />
        </View>
      </ScrollView>
    </View>
  )
}

const styles = StyleSheet.create({
  header: {
    paddingTop: Constants.statusBarHeight + 20
  },
  container: {
    width: '100%',
    flex: 1,
    backgroundColor: '#FFF',
    alignItems: 'center',
    justifyContent: 'center',
    gap: 20
  },
  title: {
    fontSize: 25
  },
  containerEstanques: {
    width: 360,
    justifyContent: 'space-between',
    flexDirection: 'row',
    flexWrap: 'wrap',
    gap: 40
  }
})

export default Inicio
