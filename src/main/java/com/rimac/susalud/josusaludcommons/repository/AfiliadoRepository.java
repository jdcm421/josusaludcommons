package com.rimac.susalud.josusaludcommons.repository;

import com.rimac.susalud.josusaludcommons.model.In271RegafiUpdateAfiliacion;
import com.rimac.susalud.josusaludcommons.model.AfiliadoEnvio;
import com.rimac.susalud.josusaludcommons.model.AfiliadoRespuesta;
import com.rimac.susalud.josusaludcommons.model.In271RegafiUpdate;
import com.rimac.susalud.josusaludcommons.model.In271RegafiUpdateAfiliado;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;
import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

public class AfiliadoRepository {

    private static final Logger LOG = LoggerFactory.getLogger(AfiliadoRepository.class);

    @Value("${procedimiento.afiliadoenvio}")
    private String prodAfiliadoEnvio;

    @Value("${procedimiento.afiliadosinicial}")
    private String prodAfiliadoInicial;

    @Value("${procedimiento.tramaafiliado}")
    private String prodTramaAfiliado;

    @Value("${procedimiento.afiliadossusalud}")
    private String prodAfiliadosSuSalud;

    @Value("${procedimiento.susaludrpta}")
    private String prodsuSaludRPTA;

    @Value("${procedimiento.idmessage}")
    private String prodidMessage;

    @Value("${procedimiento.idmesssageenvio}")
    private String prodidMessageEnvio;

    @Autowired
    EntityManager entityManager;

    public List<AfiliadoEnvio> obtenerAfiliadosEnvio(String filePropertiesName, String estadoAfiliado) throws SQLException, Exception {
        List<AfiliadoEnvio> lstIn217ResgistrosAFiliadosEnvio = new ArrayList<AfiliadoEnvio>();
        AfiliadoEnvio afiliadoEnvio = null;
        try {
            StoredProcedureQuery query = entityManager.createStoredProcedureQuery(prodAfiliadoEnvio)
                    .registerStoredProcedureParameter(1, String.class, ParameterMode.IN)
                    .registerStoredProcedureParameter(2, Object.class, ParameterMode.REF_CURSOR)
                    .setParameter(1, estadoAfiliado);
            query.execute();
            ResultSet rs = (ResultSet) query.getOutputParameterValue(2);
            while (rs.next()) {
                afiliadoEnvio = new AfiliadoEnvio();
                In271RegafiUpdate in271RegafiUpdate = new In271RegafiUpdate();
				
				if(rs.getString("IDETRAMA")!=null){afiliadoEnvio.setIdTrama(rs.getString("IDETRAMA"));}else{afiliadoEnvio.setIdTrama("");}
				if(rs.getString("NOMTRANS")!=null){in271RegafiUpdate.setNoTransaccion(rs.getString("NOMTRANS"));}else{in271RegafiUpdate.setNoTransaccion("");}
				if(rs.getString("IAFASEMISORTRANS")!=null){in271RegafiUpdate.setIdRemitente(rs.getString("IAFASEMISORTRANS"));}else{in271RegafiUpdate.setIdRemitente("");}
				if(rs.getString("NOMBRERECEPTORTRANS")!=null){in271RegafiUpdate.setIdReceptor(rs.getString("NOMBRERECEPTORTRANS"));}else{in271RegafiUpdate.setIdReceptor("");}
				if(rs.getString("FECTRANS")!=null){in271RegafiUpdate.setFeTransaccion(rs.getString("FECTRANS"));}else{in271RegafiUpdate.setFeTransaccion("");}
				if(rs.getString("HORATRANS")!=null){in271RegafiUpdate.setHoTransaccion(rs.getString("HORATRANS"));}else{in271RegafiUpdate.setHoTransaccion("");}
				if(rs.getString("CORRETRANS")!=null){in271RegafiUpdate.setIdCorrelativo(rs.getString("CORRETRANS"));}else{in271RegafiUpdate.setIdCorrelativo("");}
				if(rs.getString("IDETRANS")!=null){in271RegafiUpdate.setIdTransaccion(rs.getString("IDETRANS"));}else{in271RegafiUpdate.setIdTransaccion("");}
				if(rs.getString("CODFINALTRANS")!=null){in271RegafiUpdate.setTiFinalidad(rs.getString("CODFINALTRANS"));}else{in271RegafiUpdate.setTiFinalidad("");}
				if(rs.getString("TIPCALIFICADORTRANS")!=null){in271RegafiUpdate.setCaRemitente(rs.getString("TIPCALIFICADORTRANS"));}else{in271RegafiUpdate.setCaRemitente("");}
				if(rs.getString("TIPOPERACIONTRANS")!=null){in271RegafiUpdate.setTiOperacion(rs.getString("TIPOPERACIONTRANS"));}else{in271RegafiUpdate.setTiOperacion("");}
				
				//Registro de AFiliado
				In271RegafiUpdateAfiliado afiliado = new In271RegafiUpdateAfiliado();
				if(rs.getString("APPATERNOAFILIADO")!=null){afiliado.setApPaternoAfiliado(rs.getString("APPATERNOAFILIADO"));}else{afiliado.setApPaternoAfiliado("");}
				if(rs.getString("NOAFILIADO1")!=null){afiliado.setNoAfiliado1(rs.getString("NOAFILIADO1"));}else{afiliado.setNoAfiliado1("");}
				if(rs.getString("NOAFILIADO2")!=null){afiliado.setNoAfiliado2(rs.getString("NOAFILIADO2"));}else{afiliado.setNoAfiliado2("");}
				if(rs.getString("APMATERNOAFILIADO")!=null){afiliado.setApMaternoAfiliado(rs.getString("APMATERNOAFILIADO"));}else{afiliado.setApMaternoAfiliado("");}
				if(rs.getString("TIDOCUMENTOAFIL")!=null){afiliado.setTiDocumentoAfil(rs.getString("TIDOCUMENTOAFIL"));}else{afiliado.setTiDocumentoAfil("");}
				if(rs.getString("NUDOCUMENTOAFIL")!=null){afiliado.setNuDocumentoAfil(rs.getString("NUDOCUMENTOAFIL"));}else{afiliado.setNuDocumentoAfil("");}
				if(rs.getString("ESTADOAFILIADO")!=null){afiliado.setEstadoAfiliado(rs.getString("ESTADOAFILIADO"));}else{afiliado.setEstadoAfiliado("");}
				if(rs.getString("TIDOCUMENTOACT")!=null){afiliado.setTiDocumentoAct(rs.getString("TIDOCUMENTOACT"));}else{afiliado.setTiDocumentoAct("");}
				if(rs.getString("NUDOCUMENTOACT")!=null){afiliado.setNuDocumentoAct(rs.getString("NUDOCUMENTOACT"));}else{afiliado.setNuDocumentoAct("");}
				if(rs.getString("APCASADAAFILIADO")!=null){afiliado.setApCasadaAfiliado(rs.getString("APCASADAAFILIADO"));}else{afiliado.setApCasadaAfiliado("");}
				if(rs.getString("CONACIONALIDAD")!=null){afiliado.setCoNacionalidad(rs.getString("CONACIONALIDAD"));}else{afiliado.setCoNacionalidad("");}
				if(rs.getString("UBIGEO")!=null){afiliado.setUbigeo(rs.getString("UBIGEO"));}else{afiliado.setUbigeo("");}
				if(rs.getString("FENACIMIENTO")!=null){afiliado.setFeNacimiento(rs.getString("FENACIMIENTO"));}else{afiliado.setFeNacimiento("");}
				if(rs.getString("GENERO")!=null){afiliado.setGenero(rs.getString("GENERO"));}else{afiliado.setGenero("");}
				if(rs.getString("COPAISDOC")!=null){afiliado.setCoPaisDoc(rs.getString("COPAISDOC"));}else{afiliado.setCoPaisDoc("");}
				if(rs.getString("FEFALLECIMIENTO")!=null){afiliado.setFefallecimiento(rs.getString("FEFALLECIMIENTO"));}else{afiliado.setFefallecimiento("");}
				if(rs.getString("COPAISEMISORDOCACT")!=null){afiliado.setCoPaisEmisorDocAct(rs.getString("COPAISEMISORDOCACT"));}else{afiliado.setCoPaisEmisorDocAct("");}
				if(rs.getString("FEACTPERSONAXIAFAS")!=null){afiliado.setFeActPersonaxIafas(rs.getString("FEACTPERSONAXIAFAS"));}else{afiliado.setFeActPersonaxIafas("");}
				if(rs.getString("IDAFILIADONOMBRE")!=null){afiliado.setIdAfiliadoNombre(rs.getString("IDAFILIADONOMBRE"));}else{afiliado.setIdAfiliadoNombre("");}
				if(rs.getString("TIDOCTUTOR")!=null){afiliado.setTiDocTutor(rs.getString("TIDOCTUTOR"));}else{afiliado.setTiDocTutor("");}
				if(rs.getString("NUDOCTUTOR")!=null){afiliado.setNuDocTutor(rs.getString("NUDOCTUTOR"));}else{afiliado.setNuDocTutor("");}
				if(rs.getString("TIVINCULOTUTOR")!=null){afiliado.setTiVinculoTutor(rs.getString("TIVINCULOTUTOR"));}else{afiliado.setTiVinculoTutor("");}
				if(rs.getString("FEVALIDACIONRENIEC")!=null){afiliado.setFeValidacionReniec(rs.getString("FEVALIDACIONRENIEC"));}else{afiliado.setFeValidacionReniec("");}
				if(rs.getString("COPAISEMISORDOCTUTOR")!=null){afiliado.setCoPaisEmisorDocTutor(rs.getString("COPAISEMISORDOCTUTOR"));}else{afiliado.setCoPaisEmisorDocTutor("");}
				
				//Registro de Afiliacion
				In271RegafiUpdateAfiliacion afiliacion = new In271RegafiUpdateAfiliacion();
				if(rs.getString("TIDOCTITULAR")!=null){afiliacion.setTiDocTitular(rs.getString("TIDOCTITULAR"));}else{afiliacion.setTiDocTitular("");}
				if(rs.getString("NUDOCTITULAR")!=null){afiliacion.setNuDocTitular(rs.getString("NUDOCTITULAR"));}else{afiliacion.setNuDocTitular("");}
				if(rs.getString("FENACIMIENTOTITULAR")!=null){afiliacion.setFeNacimientoTitular(rs.getString("FENACIMIENTOTITULAR"));}else{afiliacion.setFeNacimientoTitular("");}
				if(rs.getString("COPAISEMISORDOCTITULAR")!=null){afiliacion.setCoPaisEmisorDocTitular(rs.getString("COPAISEMISORDOCTITULAR"));}else{afiliacion.setCoPaisEmisorDocTitular("");}
				if(rs.getString("TICONTRATANTE")!=null){afiliacion.setTiContratante(rs.getString("TICONTRATANTE"));}else{afiliacion.setTiContratante("");}
				if(rs.getString("APPATERNOCONTRATANTE")!=null){afiliacion.setApPaternoContratante(rs.getString("APPATERNOCONTRATANTE"));}else{afiliacion.setApPaternoContratante("");}
				if(rs.getString("NOCONTRATANTE1")!=null){afiliacion.setNoContratante1(rs.getString("NOCONTRATANTE1"));}else{afiliacion.setNoContratante1("");}
				if(rs.getString("NOCONTRATANTE2")!=null){afiliacion.setNoContratante2(rs.getString("NOCONTRATANTE2"));}else{afiliacion.setNoContratante2("");}
				if(rs.getString("NOCONTRATANTE3")!=null){afiliacion.setNoContratante3(rs.getString("NOCONTRATANTE3"));}else{afiliacion.setNoContratante3("");}
				if(rs.getString("NOCONTRATANTE4")!=null){afiliacion.setNoContratante4(rs.getString("NOCONTRATANTE4"));}else{afiliacion.setNoContratante4("");}
				if(rs.getString("APMATERNOCONTRATANTE")!=null){afiliacion.setApMaternoContratante(rs.getString("APMATERNOCONTRATANTE"));}else{afiliacion.setApMaternoContratante("");}
				if(rs.getString("TIDOCCONTRATANTE")!=null){afiliacion.setTiDocContratante(rs.getString("TIDOCCONTRATANTE"));}else{afiliacion.setTiDocContratante("");}
				if(rs.getString("NUDOCCONTRATANTE")!=null){afiliacion.setNuDocContratante(rs.getString("NUDOCCONTRATANTE"));}else{afiliacion.setNuDocContratante("");}
				if(rs.getString("APCASADACONTRATANTE")!=null){afiliacion.setApCasadaContratante(rs.getString("APCASADACONTRATANTE"));}else{afiliacion.setApCasadaContratante("");}
				if(rs.getString("FENACIMIENTOCONTRATANTE")!=null){afiliacion.setFeNacimientoContratante(rs.getString("FENACIMIENTOCONTRATANTE"));}else{afiliacion.setFeNacimientoContratante("");}
				if(rs.getString("COPAISEMISORDOCCONTRATANTE")!=null){afiliacion.setCoPaisEmisorDocContratante(rs.getString("COPAISEMISORDOCCONTRATANTE"));}else{afiliacion.setCoPaisEmisorDocContratante("");}
				if(rs.getString("COAFILIACION")!=null){afiliacion.setCoAfiliacion(rs.getString("COAFILIACION"));}else{afiliacion.setCoAfiliacion("");}
				if(rs.getString("COCONTRATO")!=null){afiliacion.setCoContrato(rs.getString("COCONTRATO"));}else{afiliacion.setCoContrato("");}
				if(rs.getString("COUNICOMULTISECTORIAL")!=null){afiliacion.setCoUnicoMultisectorial(rs.getString("COUNICOMULTISECTORIAL"));}else{afiliacion.setCoUnicoMultisectorial("");}
				if(rs.getString("TIREGIMEN")!=null){afiliacion.setTiregimen(rs.getString("TIREGIMEN"));}else{afiliacion.setTiregimen("");}
				if(rs.getString("ESAFILIACION")!=null){afiliacion.setEsAfiliacion(rs.getString("ESAFILIACION"));}else{afiliacion.setEsAfiliacion("");}
				if(rs.getString("COCAUSALBAJA")!=null){afiliacion.setCoCausalBaja(rs.getString("COCAUSALBAJA"));}else{afiliacion.setCoCausalBaja("");}
				if(rs.getString("TIPLANSALUD")!=null){afiliacion.setTiPlanSalud(rs.getString("TIPLANSALUD"));}else{afiliacion.setTiPlanSalud("");}
				if(rs.getString("NOPRODUCTOSALUD")!=null){afiliacion.setNoProductoSalud(rs.getString("NOPRODUCTOSALUD"));}else{afiliacion.setNoProductoSalud("");}
				if(rs.getString("COPRODUCTO")!=null){afiliacion.setCoProducto(rs.getString("COPRODUCTO"));}else{afiliacion.setCoProducto("");}
				if(rs.getString("PARENTESCO")!=null){afiliacion.setParentesco(rs.getString("PARENTESCO"));}else{afiliacion.setParentesco("");}
				if(rs.getString("CORENIPRESS")!=null){afiliacion.setCoRenipress(rs.getString("CORENIPRESS"));}else{afiliacion.setCoRenipress("");}
				if(rs.getString("PKAFILIADO")!=null){afiliacion.setPkAfiliado(rs.getString("PKAFILIADO"));}else{afiliacion.setPkAfiliado("");}
				if(rs.getString("FEACTESTADO")!=null){afiliacion.setFeActEstado(rs.getString("FEACTESTADO"));}else{afiliacion.setFeActEstado("");}
				if(rs.getString("FEINIAFILIACION")!=null){afiliacion.setFeIniAfiliacion(rs.getString("FEINIAFILIACION"));}else{afiliacion.setFeIniAfiliacion("");}
				if(rs.getString("FEFINAFILIACION")!=null){afiliacion.setFeFinAfiliacion(rs.getString("FEFINAFILIACION"));}else{afiliacion.setFeFinAfiliacion("");}
				if(rs.getString("FEINICOBERTURA")!=null){afiliacion.setFeIniCobertura(rs.getString("FEINICOBERTURA"));}else{afiliacion.setFeIniCobertura("");}
				if(rs.getString("FEFINCOBERTURA")!=null){afiliacion.setFeFinCobertura(rs.getString("FEFINCOBERTURA"));}else{afiliacion.setFeFinCobertura("");}
				if(rs.getString("FEACTOPERACION")!=null){afiliacion.setFeActOperacion(rs.getString("FEACTOPERACION"));}else{afiliacion.setFeActOperacion("");}
				if(rs.getString("TIACTOPERACION")!=null){afiliacion.setTiActOperacion(rs.getString("TIACTOPERACION"));}else{afiliacion.setTiActOperacion("");}
				if(rs.getString("COTICOBERTURA")!=null){afiliacion.setCoTiCobertura(rs.getString("COTICOBERTURA"));}else{afiliacion.setCoTiCobertura("");}
				if(rs.getString("IDAFILIACIONNOMBRE")!=null){afiliacion.setIdAfiliacionNombre(rs.getString("IDAFILIACIONNOMBRE"));}else{afiliacion.setIdAfiliacionNombre("");}

                in271RegafiUpdate.setAddDetalle(afiliado);
                in271RegafiUpdate.setAddDetalle(afiliacion);

                //Asignacion a lista Principal
                afiliadoEnvio.setIn271RegafiUpdate(in271RegafiUpdate);
                lstIn217ResgistrosAFiliadosEnvio.add(afiliadoEnvio);
            }
        } catch (SQLException ex) {
            LOG.error("SQLException: ", ex);
            throw ex;
        } catch (Exception ex) {
            LOG.error(estadoAfiliado, ex);
            throw ex;
        }
        return lstIn217ResgistrosAFiliadosEnvio;
    }

    public List<AfiliadoEnvio> obtenerAfiliadosCargaInicial(String filePropertiesName, String estadoAfiliado, String indicadorCargaInicial) throws SQLException, Exception {
        List<AfiliadoEnvio> lstIn217ResgistrosAFiliadosEnvio = new ArrayList<AfiliadoEnvio>();
        AfiliadoEnvio afiliadoEnvio = null;
        try {
            StoredProcedureQuery query = entityManager.createStoredProcedureQuery(prodAfiliadoEnvio)
                    .registerStoredProcedureParameter(1, String.class, ParameterMode.IN)
                    .registerStoredProcedureParameter(2, Object.class, ParameterMode.REF_CURSOR)
                    .setParameter(1, estadoAfiliado);
            query.execute();
            ResultSet rs = (ResultSet) query.getOutputParameterValue(2);
            while (rs.next()) {
                In271RegafiUpdate in271RegafiUpdate = new In271RegafiUpdate();
                afiliadoEnvio = new AfiliadoEnvio();
					if(rs.getString("IDETRAMA")!=null){afiliadoEnvio.setIdTrama(rs.getString("IDETRAMA"));}else{afiliadoEnvio.setIdTrama("");}
					if(rs.getString("INDCARGAINICIAL")!=null){afiliadoEnvio.setIndCargaInicial(rs.getString("INDCARGAINICIAL"));}else{afiliadoEnvio.setIndCargaInicial("");}
					if(rs.getString("NOMTRANS")!=null){in271RegafiUpdate.setNoTransaccion(rs.getString("NOMTRANS"));}else{in271RegafiUpdate.setNoTransaccion("");}
					if(rs.getString("IAFASEMISORTRANS")!=null){in271RegafiUpdate.setIdRemitente(rs.getString("IAFASEMISORTRANS"));}else{in271RegafiUpdate.setIdRemitente("");}
					if(rs.getString("NOMBRERECEPTORTRANS")!=null){in271RegafiUpdate.setIdReceptor(rs.getString("NOMBRERECEPTORTRANS"));}else{in271RegafiUpdate.setIdReceptor("");}
					if(rs.getString("FECTRANS")!=null){in271RegafiUpdate.setFeTransaccion(rs.getString("FECTRANS"));}else{in271RegafiUpdate.setFeTransaccion("");}
					if(rs.getString("HORATRANS")!=null){in271RegafiUpdate.setHoTransaccion(rs.getString("HORATRANS"));}else{in271RegafiUpdate.setHoTransaccion("");}
					if(rs.getString("CORRETRANS")!=null){in271RegafiUpdate.setIdCorrelativo(rs.getString("CORRETRANS"));}else{in271RegafiUpdate.setIdCorrelativo("");}
					if(rs.getString("IDETRANS")!=null){in271RegafiUpdate.setIdTransaccion(rs.getString("IDETRANS"));}else{in271RegafiUpdate.setIdTransaccion("");}
					if(rs.getString("CODFINALTRANS")!=null){in271RegafiUpdate.setTiFinalidad(rs.getString("CODFINALTRANS"));}else{in271RegafiUpdate.setTiFinalidad("");}
					if(rs.getString("TIPCALIFICADORTRANS")!=null){in271RegafiUpdate.setCaRemitente(rs.getString("TIPCALIFICADORTRANS"));}else{in271RegafiUpdate.setCaRemitente("");}
					if(rs.getString("TIPOPERACIONTRANS")!=null){in271RegafiUpdate.setTiOperacion(rs.getString("TIPOPERACIONTRANS"));}else{in271RegafiUpdate.setTiOperacion("");}
					
					//Registro de AFiliado
					In271RegafiUpdateAfiliado afiliado = new In271RegafiUpdateAfiliado();
					if(rs.getString("APPATERNOAFILIADO")!=null){afiliado.setApPaternoAfiliado(rs.getString("APPATERNOAFILIADO"));}else{afiliado.setApPaternoAfiliado("");}
					if(rs.getString("NOAFILIADO1")!=null){afiliado.setNoAfiliado1(rs.getString("NOAFILIADO1"));}else{afiliado.setNoAfiliado1("");}
					if(rs.getString("NOAFILIADO2")!=null){afiliado.setNoAfiliado2(rs.getString("NOAFILIADO2"));}else{afiliado.setNoAfiliado2("");}
					if(rs.getString("APMATERNOAFILIADO")!=null){afiliado.setApMaternoAfiliado(rs.getString("APMATERNOAFILIADO"));}else{afiliado.setApMaternoAfiliado("");}
					if(rs.getString("TIDOCUMENTOAFIL")!=null){afiliado.setTiDocumentoAfil(rs.getString("TIDOCUMENTOAFIL"));}else{afiliado.setTiDocumentoAfil("");}
					if(rs.getString("NUDOCUMENTOAFIL")!=null){afiliado.setNuDocumentoAfil(rs.getString("NUDOCUMENTOAFIL"));}else{afiliado.setNuDocumentoAfil("");}
					if(rs.getString("ESTADOAFILIADO")!=null){afiliado.setEstadoAfiliado(rs.getString("ESTADOAFILIADO"));}else{afiliado.setEstadoAfiliado("");}
					if(rs.getString("TIDOCUMENTOACT")!=null){afiliado.setTiDocumentoAct(rs.getString("TIDOCUMENTOACT"));}else{afiliado.setTiDocumentoAct("");}
					if(rs.getString("NUDOCUMENTOACT")!=null){afiliado.setNuDocumentoAct(rs.getString("NUDOCUMENTOACT"));}else{afiliado.setNuDocumentoAct("");}
					if(rs.getString("APCASADAAFILIADO")!=null){afiliado.setApCasadaAfiliado(rs.getString("APCASADAAFILIADO"));}else{afiliado.setApCasadaAfiliado("");}
					if(rs.getString("CONACIONALIDAD")!=null){afiliado.setCoNacionalidad(rs.getString("CONACIONALIDAD"));}else{afiliado.setCoNacionalidad("");}
					if(rs.getString("UBIGEO")!=null){afiliado.setUbigeo(rs.getString("UBIGEO"));}else{afiliado.setUbigeo("");}
					if(rs.getString("FENACIMIENTO")!=null){afiliado.setFeNacimiento(rs.getString("FENACIMIENTO"));}else{afiliado.setFeNacimiento("");}
					if(rs.getString("GENERO")!=null){afiliado.setGenero(rs.getString("GENERO"));}else{afiliado.setGenero("");}
					if(rs.getString("COPAISDOC")!=null){afiliado.setCoPaisDoc(rs.getString("COPAISDOC"));}else{afiliado.setCoPaisDoc("");}
					if(rs.getString("FEFALLECIMIENTO")!=null){afiliado.setFefallecimiento(rs.getString("FEFALLECIMIENTO"));}else{afiliado.setFefallecimiento("");}
					if(rs.getString("COPAISEMISORDOCACT")!=null){afiliado.setCoPaisEmisorDocAct(rs.getString("COPAISEMISORDOCACT"));}else{afiliado.setCoPaisEmisorDocAct("");}
					if(rs.getString("FEACTPERSONAXIAFAS")!=null){afiliado.setFeActPersonaxIafas(rs.getString("FEACTPERSONAXIAFAS"));}else{afiliado.setFeActPersonaxIafas("");}
					if(rs.getString("IDAFILIADONOMBRE")!=null){afiliado.setIdAfiliadoNombre(rs.getString("IDAFILIADONOMBRE"));}else{afiliado.setIdAfiliadoNombre("");}
					if(rs.getString("TIDOCTUTOR")!=null){afiliado.setTiDocTutor(rs.getString("TIDOCTUTOR"));}else{afiliado.setTiDocTutor("");}
					if(rs.getString("NUDOCTUTOR")!=null){afiliado.setNuDocTutor(rs.getString("NUDOCTUTOR"));}else{afiliado.setNuDocTutor("");}
					if(rs.getString("TIVINCULOTUTOR")!=null){afiliado.setTiVinculoTutor(rs.getString("TIVINCULOTUTOR"));}else{afiliado.setTiVinculoTutor("");}
					if(rs.getString("FEVALIDACIONRENIEC")!=null){afiliado.setFeValidacionReniec(rs.getString("FEVALIDACIONRENIEC"));}else{afiliado.setFeValidacionReniec("");}
					if(rs.getString("COPAISEMISORDOCTUTOR")!=null){afiliado.setCoPaisEmisorDocTutor(rs.getString("COPAISEMISORDOCTUTOR"));}else{afiliado.setCoPaisEmisorDocTutor("");}
					
					//Registro de Afiliacion
					In271RegafiUpdateAfiliacion afiliacion = new In271RegafiUpdateAfiliacion();
					if(rs.getString("TIDOCTITULAR")!=null){afiliacion.setTiDocTitular(rs.getString("TIDOCTITULAR"));}else{afiliacion.setTiDocTitular("");}
					if(rs.getString("NUDOCTITULAR")!=null){afiliacion.setNuDocTitular(rs.getString("NUDOCTITULAR"));}else{afiliacion.setNuDocTitular("");}
					if(rs.getString("FENACIMIENTOTITULAR")!=null){afiliacion.setFeNacimientoTitular(rs.getString("FENACIMIENTOTITULAR"));}else{afiliacion.setFeNacimientoTitular("");}
					if(rs.getString("COPAISEMISORDOCTITULAR")!=null){afiliacion.setCoPaisEmisorDocTitular(rs.getString("COPAISEMISORDOCTITULAR"));}else{afiliacion.setCoPaisEmisorDocTitular("");}
					if(rs.getString("TICONTRATANTE")!=null){afiliacion.setTiContratante(rs.getString("TICONTRATANTE"));}else{afiliacion.setTiContratante("");}
					if(rs.getString("APPATERNOCONTRATANTE")!=null){afiliacion.setApPaternoContratante(rs.getString("APPATERNOCONTRATANTE"));}else{afiliacion.setApPaternoContratante("");}
					if(rs.getString("NOCONTRATANTE1")!=null){afiliacion.setNoContratante1(rs.getString("NOCONTRATANTE1"));}else{afiliacion.setNoContratante1("");}
					if(rs.getString("NOCONTRATANTE2")!=null){afiliacion.setNoContratante2(rs.getString("NOCONTRATANTE2"));}else{afiliacion.setNoContratante2("");}
					if(rs.getString("NOCONTRATANTE3")!=null){afiliacion.setNoContratante3(rs.getString("NOCONTRATANTE3"));}else{afiliacion.setNoContratante3("");}
					if(rs.getString("NOCONTRATANTE4")!=null){afiliacion.setNoContratante4(rs.getString("NOCONTRATANTE4"));}else{afiliacion.setNoContratante4("");}
					if(rs.getString("APMATERNOCONTRATANTE")!=null){afiliacion.setApMaternoContratante(rs.getString("APMATERNOCONTRATANTE"));}else{afiliacion.setApMaternoContratante("");}
					if(rs.getString("TIDOCCONTRATANTE")!=null){afiliacion.setTiDocContratante(rs.getString("TIDOCCONTRATANTE"));}else{afiliacion.setTiDocContratante("");}
					if(rs.getString("NUDOCCONTRATANTE")!=null){afiliacion.setNuDocContratante(rs.getString("NUDOCCONTRATANTE"));}else{afiliacion.setNuDocContratante("");}
					if(rs.getString("APCASADACONTRATANTE")!=null){afiliacion.setApCasadaContratante(rs.getString("APCASADACONTRATANTE"));}else{afiliacion.setApCasadaContratante("");}
					if(rs.getString("FENACIMIENTOCONTRATANTE")!=null){afiliacion.setFeNacimientoContratante(rs.getString("FENACIMIENTOCONTRATANTE"));}else{afiliacion.setFeNacimientoContratante("");}
					if(rs.getString("COPAISEMISORDOCCONTRATANTE")!=null){afiliacion.setCoPaisEmisorDocContratante(rs.getString("COPAISEMISORDOCCONTRATANTE"));}else{afiliacion.setCoPaisEmisorDocContratante("");}
					if(rs.getString("COAFILIACION")!=null){afiliacion.setCoAfiliacion(rs.getString("COAFILIACION"));}else{afiliacion.setCoAfiliacion("");}
					if(rs.getString("COCONTRATO")!=null){afiliacion.setCoContrato(rs.getString("COCONTRATO"));}else{afiliacion.setCoContrato("");}
					if(rs.getString("COUNICOMULTISECTORIAL")!=null){afiliacion.setCoUnicoMultisectorial(rs.getString("COUNICOMULTISECTORIAL"));}else{afiliacion.setCoUnicoMultisectorial("");}
					if(rs.getString("TIREGIMEN")!=null){afiliacion.setTiregimen(rs.getString("TIREGIMEN"));}else{afiliacion.setTiregimen("");}
					if(rs.getString("ESAFILIACION")!=null){afiliacion.setEsAfiliacion(rs.getString("ESAFILIACION"));}else{afiliacion.setEsAfiliacion("");}
					if(rs.getString("COCAUSALBAJA")!=null){afiliacion.setCoCausalBaja(rs.getString("COCAUSALBAJA"));}else{afiliacion.setCoCausalBaja("");}
					if(rs.getString("TIPLANSALUD")!=null){afiliacion.setTiPlanSalud(rs.getString("TIPLANSALUD"));}else{afiliacion.setTiPlanSalud("");}
					if(rs.getString("NOPRODUCTOSALUD")!=null){afiliacion.setNoProductoSalud(rs.getString("NOPRODUCTOSALUD"));}else{afiliacion.setNoProductoSalud("");}
					if(rs.getString("COPRODUCTO")!=null){afiliacion.setCoProducto(rs.getString("COPRODUCTO"));}else{afiliacion.setCoProducto("");}
					if(rs.getString("PARENTESCO")!=null){afiliacion.setParentesco(rs.getString("PARENTESCO"));}else{afiliacion.setParentesco("");}
					if(rs.getString("CORENIPRESS")!=null){afiliacion.setCoRenipress(rs.getString("CORENIPRESS"));}else{afiliacion.setCoRenipress("");}
					if(rs.getString("PKAFILIADO")!=null){afiliacion.setPkAfiliado(rs.getString("PKAFILIADO"));}else{afiliacion.setPkAfiliado("");}
					if(rs.getString("FEACTESTADO")!=null){afiliacion.setFeActEstado(rs.getString("FEACTESTADO"));}else{afiliacion.setFeActEstado("");}
					if(rs.getString("FEINIAFILIACION")!=null){afiliacion.setFeIniAfiliacion(rs.getString("FEINIAFILIACION"));}else{afiliacion.setFeIniAfiliacion("");}
					if(rs.getString("FEFINAFILIACION")!=null){afiliacion.setFeFinAfiliacion(rs.getString("FEFINAFILIACION"));}else{afiliacion.setFeFinAfiliacion("");}
					if(rs.getString("FEINICOBERTURA")!=null){afiliacion.setFeIniCobertura(rs.getString("FEINICOBERTURA"));}else{afiliacion.setFeIniCobertura("");}
					if(rs.getString("FEFINCOBERTURA")!=null){afiliacion.setFeFinCobertura(rs.getString("FEFINCOBERTURA"));}else{afiliacion.setFeFinCobertura("");}
					if(rs.getString("FEACTOPERACION")!=null){afiliacion.setFeActOperacion(rs.getString("FEACTOPERACION"));}else{afiliacion.setFeActOperacion("");}
					if(rs.getString("TIACTOPERACION")!=null){afiliacion.setTiActOperacion(rs.getString("TIACTOPERACION"));}else{afiliacion.setTiActOperacion("");}
					if(rs.getString("COTICOBERTURA")!=null){afiliacion.setCoTiCobertura(rs.getString("COTICOBERTURA"));}else{afiliacion.setCoTiCobertura("");}
					if(rs.getString("IDAFILIACIONNOMBRE")!=null){afiliacion.setIdAfiliacionNombre(rs.getString("IDAFILIACIONNOMBRE"));}else{afiliacion.setIdAfiliacionNombre("");}

                in271RegafiUpdate.setAddDetalle(afiliado);
                in271RegafiUpdate.setAddDetalle(afiliacion);

                //Asignacion a lista Principal
                afiliadoEnvio.setIn271RegafiUpdate(in271RegafiUpdate);
                lstIn217ResgistrosAFiliadosEnvio.add(afiliadoEnvio);
            }
        } catch (SQLException ex) {
            LOG.error("SQLException: ", ex);
            throw ex;
        } catch (Exception ex) {
            LOG.error("Exception: ", ex);
            throw ex;
        }
        return lstIn217ResgistrosAFiliadosEnvio;
    }

    public boolean actualizarTramaAfiliado(String filePropertiesName, String idTrama, String estadoAfiliado) throws SQLException, Exception {
        return false;
    }

    public List<AfiliadoRespuesta> obtenerAfiliadosSuSalud(String filePropertiesName, String estadoTrama) throws SQLException, Exception {
        return null;
    }

    public boolean insertarSuSaludRespuesta(String filePropertiesName, String tramaestado, String indcargainicial, In997RegafiUpdate afiliadoRpta, byte[] msgId) throws SQLException, Exception {
        return false;
    }

    public boolean actualizarIdMessage(String filePropertiesName, String idTrama, byte[] idmessage) throws SQLException, Exception {
        return false;
    }

    public TreeMap<Integer, byte[]> obtenerIdmessageEnvio(String filePropertiesName, String estadoAfiliado) throws SQLException, Exception {
        return null;
    }

}
