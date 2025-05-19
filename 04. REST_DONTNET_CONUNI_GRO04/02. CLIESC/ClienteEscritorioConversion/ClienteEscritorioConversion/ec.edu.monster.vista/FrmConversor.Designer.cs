namespace ClienteEscritorioConversion.ec.edu.monster.vista
{
    partial class FrmConversor
    {
        /// <summary>
        /// Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Clean up any resources being used.
        /// </summary>
        /// <param name="disposing">true if managed resources should be disposed; otherwise, false.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Windows Form Designer generated code

        /// <summary>
        /// Required method for Designer support - do not modify
        /// the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            System.ComponentModel.ComponentResourceManager resources = new System.ComponentModel.ComponentResourceManager(typeof(FrmConversor));
            this.cmbConversion = new System.Windows.Forms.ComboBox();
            this.lblSeleccion = new System.Windows.Forms.Label();
            this.lblValor = new System.Windows.Forms.Label();
            this.lblTitulo = new System.Windows.Forms.Label();
            this.txtValor = new System.Windows.Forms.TextBox();
            this.btnConvertir = new System.Windows.Forms.Button();
            this.lblResultado = new System.Windows.Forms.Label();
            this.SuspendLayout();
            // 
            // cmbConversion
            // 
            this.cmbConversion.FormattingEnabled = true;
            this.cmbConversion.Location = new System.Drawing.Point(258, 138);
            this.cmbConversion.Name = "cmbConversion";
            this.cmbConversion.Size = new System.Drawing.Size(195, 24);
            this.cmbConversion.TabIndex = 0;
            this.cmbConversion.SelectedIndexChanged += new System.EventHandler(this.cmbConversion_SelectedIndexChanged);
            // 
            // lblSeleccion
            // 
            this.lblSeleccion.AutoSize = true;
            this.lblSeleccion.Location = new System.Drawing.Point(62, 141);
            this.lblSeleccion.Name = "lblSeleccion";
            this.lblSeleccion.Size = new System.Drawing.Size(147, 16);
            this.lblSeleccion.TabIndex = 1;
            this.lblSeleccion.Text = "Seleccione una opción:";
            this.lblSeleccion.Click += new System.EventHandler(this.lblSeleccion_Click);
            // 
            // lblValor
            // 
            this.lblValor.AutoSize = true;
            this.lblValor.Location = new System.Drawing.Point(102, 197);
            this.lblValor.Name = "lblValor";
            this.lblValor.Size = new System.Drawing.Size(107, 16);
            this.lblValor.TabIndex = 2;
            this.lblValor.Text = "Ingrese un Valor:";
            this.lblValor.Click += new System.EventHandler(this.lblValor_Click);
            // 
            // lblTitulo
            // 
            this.lblTitulo.AutoSize = true;
            this.lblTitulo.Location = new System.Drawing.Point(173, 58);
            this.lblTitulo.Name = "lblTitulo";
            this.lblTitulo.Size = new System.Drawing.Size(156, 16);
            this.lblTitulo.TabIndex = 3;
            this.lblTitulo.Text = "Conversión de Unidades";
            this.lblTitulo.Click += new System.EventHandler(this.lblTitulo_Click);
            // 
            // txtValor
            // 
            this.txtValor.Location = new System.Drawing.Point(258, 191);
            this.txtValor.Name = "txtValor";
            this.txtValor.Size = new System.Drawing.Size(141, 22);
            this.txtValor.TabIndex = 4;
            this.txtValor.TextChanged += new System.EventHandler(this.txtValor_TextChanged);
            // 
            // btnConvertir
            // 
            this.btnConvertir.Location = new System.Drawing.Point(188, 277);
            this.btnConvertir.Name = "btnConvertir";
            this.btnConvertir.Size = new System.Drawing.Size(75, 23);
            this.btnConvertir.TabIndex = 5;
            this.btnConvertir.Text = "Convertir";
            this.btnConvertir.UseVisualStyleBackColor = true;
            this.btnConvertir.Click += new System.EventHandler(this.btnConvertir_Click);
            // 
            // lblResultado
            // 
            this.lblResultado.AutoSize = true;
            this.lblResultado.Location = new System.Drawing.Point(137, 344);
            this.lblResultado.Name = "lblResultado";
            this.lblResultado.Size = new System.Drawing.Size(72, 16);
            this.lblResultado.TabIndex = 6;
            this.lblResultado.Text = "Resultado:";
            this.lblResultado.Click += new System.EventHandler(this.lblResultado_Click);
            // 
            // FrmConversor
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(8F, 16F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.BackgroundImage = ((System.Drawing.Image)(resources.GetObject("$this.BackgroundImage")));
            this.ClientSize = new System.Drawing.Size(519, 518);
            this.Controls.Add(this.lblResultado);
            this.Controls.Add(this.btnConvertir);
            this.Controls.Add(this.txtValor);
            this.Controls.Add(this.lblTitulo);
            this.Controls.Add(this.lblValor);
            this.Controls.Add(this.lblSeleccion);
            this.Controls.Add(this.cmbConversion);
            this.Name = "FrmConversor";
            this.Text = "FrmConversor";
            this.Load += new System.EventHandler(this.FrmConversor_Load);
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.ComboBox cmbConversion;
        private System.Windows.Forms.Label lblSeleccion;
        private System.Windows.Forms.Label lblValor;
        private System.Windows.Forms.Label lblTitulo;
        private System.Windows.Forms.TextBox txtValor;
        private System.Windows.Forms.Button btnConvertir;
        private System.Windows.Forms.Label lblResultado;
    }
}