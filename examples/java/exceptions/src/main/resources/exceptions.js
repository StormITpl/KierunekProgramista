function method_a() {
    method_bb();
}

function method_bb() {
    method_ccc();
}

function method_ccc() {
    throw 'Exception from method_ccc';
}


try {
    method_a();
} catch (e) {
    console.error("Error: " + e)
} finally {
    console.log('Block finally.')
}