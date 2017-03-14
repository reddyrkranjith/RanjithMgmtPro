/* ------------------------------------------------------------------------------
*
*  # CKEditor editor
*
*  Specific JS code additions for editor_ckeditor.html page
*
*  Version: 1.0
*  Latest update: Aug 1, 2015
*
* ---------------------------------------------------------------------------- */

$(function() {

    // Select2 select
    // ------------------------------

    // Basic
    $('.select').select2();

    // File input
    $(".file-styled").uniform({
        fileButtonClass: 'action btn bg-pink-400'
    });
    
    // Full featured editor
    CKEDITOR.replace( 'editor-full', {
        height: '400px',
        extraPlugins: 'forms'
    });
    
});
