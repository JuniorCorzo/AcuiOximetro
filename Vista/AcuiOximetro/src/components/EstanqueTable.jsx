import React from 'react'
import { View, Text, StyleSheet } from 'react-native'

const EstanqueTable = () => {
  return (
    <View style={styles.containerTableEstanque}>
      <View>
        <View style={[styles.rowBorder, styles.rowContanier]}>
          <Text style={styles.rowText}>Nivel Actual de Oxigeno</Text>
        </View>
        <View style={[styles.rowBorder, styles.rowContanier]}>
          <Text style={styles.rowText}>Tipo de Estanque</Text>
        </View>
        <View style={[styles.rowBorder, styles.rowContanier]}>
          <Text style={styles.rowText}>Especide de Pescado</Text>
        </View>
        <View style={styles.rowContanier}>
          <Text style={styles.rowText}>Cantidad de Peces</Text>
        </View>
      </View>
      <View>
        <View style={[styles.rowBorder, styles.rowContanier]}>
          <Text style={styles.rowText}>24 Mg</Text>
        </View>
        <View style={[styles.rowBorder, styles.rowContanier]}>
          <Text style={styles.rowText}>Geomembrana</Text>
        </View>
        <View style={[styles.rowBorder, styles.rowContanier]}>
          <Text style={styles.rowText}>Cachama</Text>
        </View>
        <View style={styles.rowContanier}>
          <Text style={styles.rowText}>1000</Text>
        </View>
      </View>
    </View>
  )
}

const styles = StyleSheet.create({
  containerTableEstanque: {
    width: '95%',
    borderWidth: 1,
    borderRadius: 5,
    justifyContent: 'center',
    flexDirection: 'row'
  },
  rowBorder: {
    borderBottomWidth: 1,
    borderRadius: 5
  },
  rowContanier: {
    width: '13em',
    height: 45,
    justifyContent: 'center'
  },
  rowText: {
    fontSize: 15,
    textAlign: 'center'
  }
})

export default EstanqueTable
